package base;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame() {

        Board board = new Board();

        // frame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1200, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        setTitle("Space Invaders");
        add(board);
        setVisible(true);

    }

}
