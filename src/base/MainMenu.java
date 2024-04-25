package base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    public static ImageIcon icon = new ImageIcon("src/Sprites/asteroid.png");

    public MainMenu() {
        // Set the frame layout
        this.setLayout(new BorderLayout());

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("src/base/background.png"); // replace with your image path
        JLabel backgroundLabel = new JLabel(backgroundImage);
        this.add(backgroundLabel, BorderLayout.CENTER);
        backgroundLabel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        // Create the game title
        JLabel titleLabel = new JLabel("Space Invaders");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        titleLabel.setForeground(Color.WHITE);
        backgroundLabel.add(titleLabel, gbc);

        // Create the play button
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("Arial", Font.BOLD, 50));
        playButton.setBackground(Color.GREEN);
        playButton.setForeground(Color.WHITE);
        playButton.setFocusPainted(false);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weighty = 1;

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameFrame();
                dispose(); // Close the main menu
            }
        });

        // Add the play button to the frame
        backgroundLabel.add(playButton, gbc);

        // Set frame properties
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null); // Center the frame
        this.setVisible(true);
        this.setIconImage(icon.getImage());
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}