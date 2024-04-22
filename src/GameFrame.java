import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame() {

        Board board = new Board();

        // frame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1200, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        setTitle("Tea Time");
        add(board);
        setVisible(true);

    }

    public static void main(String[] args) {
        new GameFrame();
    }
}
