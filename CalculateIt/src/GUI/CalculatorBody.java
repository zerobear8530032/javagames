package GUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ActionButtons.BackSpace;
import ActionButtons.Equal;
import ButtonInterface.ButtonInterface;
import NumberButtons.Eight;
import NumberButtons.Four;
import NumberButtons.Nine;
import NumberButtons.One;
import NumberButtons.Seven;
import NumberButtons.Six;
import NumberButtons.Three;
import NumberButtons.Two;
import NumberButtons.Zero;
import OperatorsButtons.Add;
import OperatorsButtons.Divide;
import OperatorsButtons.Mod;
import OperatorsButtons.Multiply;
import OperatorsButtons.Substract;


public class CalculatorBody extends JPanel implements ActionListener {
    CalculatorInput inputbox;
    ButtonPad buttonpad;
    public CalculatorBody(List<ButtonInterface> buttons) {
        setLayout(new GridBagLayout());
        setOpaque(false); // Transparent to let background show

        GridBagConstraints gbc = new GridBagConstraints();

        // Input field
        inputbox = new CalculatorInput();
        gbc.gridx = 0;
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        gbc1.weightx = 1.0;
        gbc1.weighty = 0.0;
        gbc1.insets = new Insets(5, 5, 2, 5); // tighter space

        inputbox = new CalculatorInput();
        inputbox.setPreferredSize(new Dimension(400, 50)); // optional
        this.add(inputbox, gbc1);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.weightx = 1.0;
        gbc2.weighty = 1.0;
        gbc2.insets = new Insets(2, 5, 5, 5); // smaller top margin

        buttonpad = new ButtonPad(buttons, inputbox.getInput());
        this.add(buttonpad, gbc2);
        
    
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Random ran = new Random();
        int num = ran.nextInt(1000); // You can limit this to reasonable digits
        inputbox.getInput().setText(Integer.toString(num));
    }

    public static void main(String[] args) {
    	
        JFrame f = new JFrame();
        List<ButtonInterface>  buttons= new ArrayList();
		buttons.add(new One(2,4,true,new JButton()));
		buttons.add(new Two(2,4,true,new JButton()));
		buttons.add(new Three(2,4,true,new JButton()));
		buttons.add(new Four(2,4,true,new JButton()));
		buttons.add(new Six(2,4,true,new JButton()));
		buttons.add(new Seven(2,4,true,new JButton()));
		buttons.add(new Eight(2,4,true,new JButton()));
		buttons.add(new Nine(2,4,true,new JButton()));
		buttons.add(new Zero(2,4,true,new JButton()));
		buttons.add(new Add(2,4,true,new JButton()));
		buttons.add(new Substract(2,4,true,new JButton()));
		buttons.add( new Divide(2,4,true,new JButton()));
		buttons.add( new Multiply(2,4,true,new JButton()));
		buttons.add( new Mod(2,4,true,new JButton()));
		buttons.add( new BackSpace(2,4,true,new JButton()));
		buttons.add( new Equal(2,4,true,new JButton()));
        f.add(new CalculatorBody(buttons));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(1000, 1000));
        f.setLocationRelativeTo(null);
        f.setVisible(true);	
    }
}


