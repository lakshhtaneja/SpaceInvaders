package base;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import sprites.Player;
import sprites.UninterestedUniverse;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Board extends JPanel {
    BufferedImage background;
    Player player;
    UninterestedUniverse enemy;
    Timer timer;

    public Board() {
        // board settings
        setSize(1200, 600);
        loadBackground();
        player = new Player();
        enemy = new UninterestedUniverse();
        gameLoop();
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, 1200, 600, null);
        player.draw(g);
        enemy.draw(g);

    }
}
