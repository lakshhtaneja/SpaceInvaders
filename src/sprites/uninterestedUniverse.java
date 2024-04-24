package sprites;

import javax.swing.ImageIcon;

public class UninterestedUniverse extends Sprite {

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

    public void update() {
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
