package sprites;

import javax.swing.ImageIcon;
import java.awt.Graphics;

public class Player {
    int x = 0;
    int y = 1000;
    int width = 100;
    int height = 100;

    ImageIcon player;

    public Player() {
        x = 100;
        y = 100;
        width = 50;
        height = 50;

        player = new ImageIcon("src/sprites/player.jpeg");
    }

    public void draw(Graphics g) {
        g.drawImage(player.getImage(), x, y, width, height, null);
    }
}
