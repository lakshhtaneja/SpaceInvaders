package sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public abstract class Sprite {
    int x;
    int y;
    int speed;
    int width;
    int height;
    int directionX;
    int directionY;
    ImageIcon image;

    public void draw(Graphics g) {
        g.drawImage(image.getImage(), x, y, width, height, null);
    }
}
