package sprites;

import javax.swing.ImageIcon;

public class Bullet extends Sprite {
    public Bullet(int x, int y, int size, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        directionX = 0;
        directionY = -1;
        width = size;
        height = size;
        image = new ImageIcon("src/sprites/laserBullet.png");
    }

    public void update() {
        y += speed * directionY;
    }
}
