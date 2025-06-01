package GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import ButtonInterface.ButtonInterface;
import NumberButtons.Five;
import NumberButtons.Four;
import NumberButtons.One;
import NumberButtons.Six;
import NumberButtons.Three;
import NumberButtons.Two;

public class ShopPanel extends JPanel {
    List<ButtonInterface> buttons;

    public ShopPanel(List<ButtonInterface> buttons) {
        this.buttons = buttons;
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(new Color(245, 245, 245));
        this.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Allow resizing
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1;
        gbc.weighty = 1;

        for (int i = 0; i < buttons.size(); i++) {
            gbc.gridx = i % 3;
            gbc.gridy = i / 3;
            buttons.get(i).setupButton();

            JButton btn = buttons.get(i).getButton();
            btn.setPreferredSize(new Dimension(120, 50));
            btn.setFont(new Font("Arial", Font.BOLD, 14));
            btn.setBackground(new Color(220, 220, 250));
            btn.setFocusPainted(false);

            this.add(btn, gbc);
        }
    }

    public static void main(String[] args) {
        List<ButtonInterface> buttons = new ArrayList<>();
        buttons.add(new One(2, 4, true, new JButton()));
        buttons.add(new Two(2, 4, true, new JButton()));
        buttons.add(new Three(2, 4, true, new JButton()));
        buttons.add(new Four(2, 4, true, new JButton()));
        buttons.add(new Five(2, 4, true, new JButton()));
        buttons.add(new Six(2, 4, true, new JButton()));

        JFrame frame = new JFrame("Button Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new ShopPanel(buttons));
        frame.pack();
        frame.setVisible(true);
    }
}
