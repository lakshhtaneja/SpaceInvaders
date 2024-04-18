import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame() {
        // frame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1200, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        setTitle("Tea Time");

        setVisible(true);

    }

    public static void main(String[] args) {
        new GameFrame();
    }
}
