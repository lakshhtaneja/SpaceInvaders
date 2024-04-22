import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

public class Board extends JPanel {
    public Board() {
        // board settings
        setSize(getPreferredSize());
        setBackground(Color.black);
        setFocusable(true);
    }

    private void loadBackground() {
        // load background image
        try {
            ImageIO.read(Board.class.getResource("background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // drawBoard(g);
    }
}
