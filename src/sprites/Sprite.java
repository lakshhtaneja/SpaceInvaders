package sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public abstract class Sprite {
    int x;
    int y;
    public int speed;
    int width;
    int height;
    public int directionX;
    public int directionY;
    ImageIcon image;

    public void draw(Graphics g) {
        g.drawImage(image.getImage(), x, y, width, height, null);
    }
}
