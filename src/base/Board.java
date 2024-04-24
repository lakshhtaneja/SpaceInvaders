package base;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import sprites.Bullet;
import sprites.Player;
import sprites.UninterestedUniverse;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Board extends JPanel {
    BufferedImage background;
    Player player;
    ArrayList<UninterestedUniverse> enemies = new ArrayList<>();
    ArrayList<Bullet> bullets = new ArrayList<>();
    Timer timer;

    public Board() {
        // board settings
        setSize(1200, 600);

        loadBackground();
        player = new Player();

        createEnemies();
        gameLoop();
        setFocusable(true);
        bindEvents();
    }

    private void gameOver(Graphics g) {
        for (UninterestedUniverse enemy : enemies) {
            if (isCollide(enemy)) {
                g.setColor(Color.RED);
                g.setFont(g.getFont().deriveFont(50.0f));
                g.drawString("Game Over", 450, 300);
                timer.stop();
            }
        }
    }

    private boolean isCollide(UninterestedUniverse enemy) {
        int xDist = Math.abs(player.x - enemy.x);
        int yDist = Math.abs(player.y - enemy.y);
        int maxHeight = Math.max(player.height / 3, enemy.height / 3);
        int maxWidth = Math.max(player.width / 4, enemy.width / 4);
        return xDist < maxWidth && yDist < maxHeight;
    }

    private boolean isCollide(Bullet bullet, UninterestedUniverse enemy) {
        int xDist = Math.abs(bullet.x - enemy.x);
        int yDist = Math.abs(bullet.y - enemy.y);
        int maxHeight = Math.max(bullet.height / 3, enemy.height / 3);
        int maxWidth = Math.max(bullet.width / 4, enemy.width / 4);
        return xDist < maxWidth && yDist < maxHeight;
    }

    private void checkCollisions() {
        for (Bullet bullet : bullets) {
            for (UninterestedUniverse enemy : enemies) {
                if (isCollide(bullet, enemy)) {
                    bullets.remove(bullet);
                    enemies.remove(enemy);
                    break;
                }
            }
        }
    }

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

    private void createEnemies() {
        Random rand = new Random();
        int directionX;
        int size = 100;
        for (int i = 0; i < 10; i++) {
            directionX = rand.nextInt(3) - 1;
            enemies.add(new UninterestedUniverse(
                    rand.nextInt(1100), rand.nextInt(100), size, 5, directionX));
            size -= 10;
        }
    }

    private void gameLoop() {
        timer = new Timer(1000 / 60, e -> {
            // player.update();
            repaint();
            for (UninterestedUniverse enemy : enemies) {
                enemy.update();
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
        gameOver(g);
    }
}
