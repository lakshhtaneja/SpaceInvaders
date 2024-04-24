package sprites;

import javax.swing.ImageIcon;

public class Player extends Sprite {

    public Player() {
        x = 550;
        y = 250;
        width = 100;
        height = 100;

        image = new ImageIcon("src/sprites/player.jpeg");
    }

}
