package base;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import sprites.Player;
import sprites.UninterestedUniverse;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Board extends JPanel {
    BufferedImage background;
    Player player;
    UninterestedUniverse enemies[] = new UninterestedUniverse[9];
    Timer timer;

    public Board() {
        // board settings
        setSize(1200, 600);
        loadBackground();
        player = new Player();
        createEnemies();
        gameLoop();
    }

    private void createEnemies() {
        Random rand = new Random();
        int directionX;
        int directionY;
        int size = 100;
        for (int i = 0; i < enemies.length; i++) {
            directionX = rand.nextInt(3) - 1;
            directionY = rand.nextInt(3) - 1;
            enemies[i] = new UninterestedUniverse(
                    rand.nextInt(1100), rand.nextInt(500), size, 5, directionX,
                    directionY);
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
        printEnemies(g);

    }
}
