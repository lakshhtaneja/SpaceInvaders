package sprites;

import javax.swing.ImageIcon;

public class UninterestedUniverse extends Sprite {
    public UninterestedUniverse(int x, int y, int size) {
        this.x = x;
        this.y = y;
        width = size;
        height = size;
        image = new ImageIcon("src/sprites/asteroid.png");
    }

}
