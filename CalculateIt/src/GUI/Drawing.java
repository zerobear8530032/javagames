package GUI;

import javax.swing.*;
import java.awt.*;

public class Drawing extends JPanel {

    private int score = 42; // You can update this dynamically

    @Override
    protected void paintComponent(Graphics g) {
   }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Score Badge Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        Drawing panel = new Drawing();
        panel.setBackground(Color.DARK_GRAY); // background color for visibility
        frame.add(panel);

        frame.setVisible(true);
    }
}
