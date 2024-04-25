package sprites;

import javax.swing.ImageIcon;
import java.awt.Graphics;

public class UninterestedUniverse extends Sprite {
    public ImageIcon img = new ImageIcon("src/sprites/love.gif");
    public boolean exploding = false;

    public UninterestedUniverse(int x, int y, int size, int speed, int directionX) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.directionX = directionX;
        directionY = 1;
        width = size;
        height = size;
        image = new ImageIcon("src/sprites/asteroid.png");
    }

    public void explode(Graphics g, UninterestedUniverse enemy) {
        g.drawImage(img.getImage(), enemy.x, enemy.y, 200, 200, null);
    }

    public void update() {
        if (exploding) {
            return;
        }
        x += speed * directionX;
        y += speed * directionY;

        if (x > 1200) {
            x = 0;
        }
        if (x < 0) {
            x = 1200;
        }
        if (y > 600) {

        }
    }

}
