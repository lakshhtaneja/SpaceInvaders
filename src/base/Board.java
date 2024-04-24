package base;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import sprites.Bullet;
import sprites.Player;
import sprites.UninterestedUniverse;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Board extends JPanel {
    int lives = 5;
    BufferedImage background;
    Player player;
    ArrayList<UninterestedUniverse> enemies = new ArrayList<>();
    ArrayList<Bullet> bullets = new ArrayList<>();
    Timer timer;
    Timer enemySpawnTimer;

    public Board() {
        // board settings
        setSize(1200, 600);

        loadBackground();
        player = new Player();
        enemySpawnTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add a new enemy
                enemies.add(createEnemy());
            }
        });
        enemySpawnTimer.start();
        gameLoop();
        setFocusable(true);
        bindEvents();
    }

    private void gameOver(Graphics g) {
        if (!player.isAlive()) {
            g.setColor(Color.RED);
            g.setFont(g.getFont().deriveFont(50.0f));
            g.drawString("Game Over", 450, 250);
            g.setColor(Color.WHITE);
            g.drawString("Your Score was " + player.points, 380, 350);
            timer.stop();
        }
    }

    // collision physics

    private boolean isCollide(Bullet bullet, UninterestedUniverse enemy) {
        int xDist = Math.abs(bullet.x - enemy.x);
        int yDist = Math.abs(bullet.y - enemy.y);
        int maxHeight = Math.max(bullet.height, enemy.height);
        int maxWidth = Math.max(bullet.width, enemy.width);
        return xDist < maxWidth && yDist < maxHeight;
    }

    private void checkCollisions() {
        for (Iterator<Bullet> bulletIterator = bullets.iterator(); bulletIterator.hasNext();) {
            Bullet bullet = bulletIterator.next();
            for (UninterestedUniverse enemy : enemies) {
                if (isCollide(bullet, enemy)) {
                    bulletIterator.remove(); // safely remove the bullet
                    enemies.remove(enemy);
                    player.addPoints();
                    break;
                }
            }
        }
    }

    // bind events
    private void bindEvents() {
        addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    bullets.add(new Bullet(player.x + player.width / 2, player.y, 10, 10));

                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.directionX = -1;

                    player.speed = 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.directionX = 1;

                    player.speed = 5;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.speed = 0;
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

        });
    }

    private UninterestedUniverse createEnemy() {
        Random rand = new Random();
        int directionX = rand.nextInt(3) - 1;
        return new UninterestedUniverse(rand.nextInt(1100), rand.nextInt(100), 100, 5, directionX);
    }

    private void gameLoop() {
        timer = new Timer(1000 / 60, e -> {
            repaint();
            for (Iterator<UninterestedUniverse> iterator = enemies.iterator(); iterator.hasNext();) {
                UninterestedUniverse enemy = iterator.next();
                enemy.update();

                // check if enemy has hit the bottom
                if (enemy.y + enemy.height >= getHeight()) {
                    iterator.remove();
                    player.loseLife();
                }
            }
        });
        timer.start();
    }

    private void loadBackground() {
        // load background image
        try {
            background = ImageIO.read(Board.class.getResource("background.png"));
        } catch (IOException e) {
            System.exit(1);
            e.printStackTrace();
        }
    }

    private void printEnemies(Graphics g) {
        for (UninterestedUniverse enemy : enemies) {
            enemy.draw(g);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, 1200, 600, null);
        player.draw(g);
        player.update();
        checkCollisions();
        for (Bullet bullet : bullets) {
            bullet.draw(g);
            bullet.update();
        }
        printEnemies(g);
        g.setColor(Color.WHITE);
        g.setFont(g.getFont().deriveFont(20.0f));
        g.drawString("Points: " + player.points, 10, 40);
        g.setColor(Color.RED);
        g.drawString("Lives: " + player.lives, 1100, 40);
        gameOver(g);
    }
}
