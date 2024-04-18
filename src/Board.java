import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class Board extends JPanel {
    public Board() {
        // board settings
        setSize(getPreferredSize());
        setBackground(Color.black);
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // drawBoard(g);
    }
}
