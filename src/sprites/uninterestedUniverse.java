package sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class UninterestedUniverse {
    int x;
    int y;
    int width;
    int height;
    ImageIcon image;

    public UninterestedUniverse() {
        x = 250;
        y = 125;
        width = 100;
        height = 100;

        image = new ImageIcon("src/sprites/asteroid.png");
    }

    public void draw(Graphics g) {
        g.drawImage(image.getImage(), x, y, width, height, null);
    }
}
