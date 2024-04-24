package sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public abstract class Sprite {
    public int x;
    public int y;
    public int speed;
    public int width;
    public int height;
    public int directionX;
    public int directionY;
    ImageIcon image;

    public void draw(Graphics g) {
        g.drawImage(image.getImage(), x, y, width, height, null);
    }
}
