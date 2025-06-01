package GUI;
import javax.swing.*;
import java.awt.*;

public class ButtonWithUsageTest extends JFrame {
    public ButtonWithUsageTest() {
        setTitle("Button with Usage Overlay Test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Create a button
        JButton button = new JButton("3"); // '3' is usage count
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setHorizontalTextPosition(SwingConstants.RIGHT);
        button.setVerticalTextPosition(SwingConstants.TOP);
        button.setPreferredSize(new Dimension(100, 100));

        // Load image icon (replace with your own button image path)
        ImageIcon icon = new ImageIcon("button.jpg");
        button.setIcon(icon);

        // Remove button borders and default background
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);

        // Add button to frame
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ButtonWithUsageTest().setVisible(true);
        });
    }
}
