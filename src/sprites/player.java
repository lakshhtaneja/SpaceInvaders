package sprites;

import javax.swing.ImageIcon;

public class Player extends Sprite {

    int velocity;
    public int lives;
    public int points;

    public Player() {
        lives = 5;
        velocity = 0;
        x = 550;
        y = 450;
        width = 100;
        height = 100;
        directionX = 1;
        image = new ImageIcon("src/sprites/player.jpeg");
    }

    public void update() {
        velocity += speed;
        x += velocity * directionX;
        velocity *= 0.9;
        if (x < 0) {
            x = 0;
        }
        if (x > 1200) {
            x = 1200;
        }
    }

    public void addPoints() {
        points++;
    }

    public void loseLife() {
        lives--;
    }

    public boolean isAlive() {
        return lives > 0;
    }
}
