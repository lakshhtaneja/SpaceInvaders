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
    UninterestedUniverse enemies[] = new UninterestedUniverse[10];
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
        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new UninterestedUniverse(rand.nextInt(1200), rand.nextInt(600), 50);
        }
    }

    private void gameLoop() {
        timer = new Timer(1000 / 60, e -> {
            // player.update();
            repaint();
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
