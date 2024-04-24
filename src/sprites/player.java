package sprites;

import javax.swing.ImageIcon;
import java.awt.Graphics;

public class Player {
    int x;
    int y;
    int width;
    int height;

    ImageIcon player;

    public Player() {
        x = 100;
        y = 100;
        width = 100;
        height = 100;

        player = new ImageIcon("src/sprites/player.jpeg");
    }

    public void draw(Graphics g) {
        g.drawImage(player.getImage(), x, y, width, height, null);
    }
}
