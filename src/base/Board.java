package base;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import sprites.Player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Board extends JPanel {
    BufferedImage background;
    Player player;

    public Board() {
        // board settings
        setSize(1200, 600);
        loadBackground();
        player = new Player();
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
    }
}
