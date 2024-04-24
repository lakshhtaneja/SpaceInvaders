package sprites;

import javax.swing.ImageIcon;

public class Player extends Sprite {

    public Player() {
        x = 550;
        y = 250;
        width = 100;
        height = 100;
        directionX = 1;
        directionY = -1;
        image = new ImageIcon("src/sprites/player.jpeg");
    }

    public void update() {
        x += speed * directionX;
        y += speed * directionY;

        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (x > 1200) {
            x = 1200;
        }
        if (y > 600) {
            y = 600;
        }
    }
}
