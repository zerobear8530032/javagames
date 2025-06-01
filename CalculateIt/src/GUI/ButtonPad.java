package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import ActionButtons.BackSpace;
import ActionButtons.Equal;
import ButtonInterface.ButtonInterface;
import ButtonInterface.NumberButtonInterface;
import NumberButtons.Eight;
import NumberButtons.Five;
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

public class ButtonPad  extends JPanel implements ActionListener{
	List<ButtonInterface> buttons;
	JLabel input ;

	
	
	public List<ButtonInterface> getMatrix() {
		return buttons;
	}

	public void setMatrix(List<ButtonInterface> buttons) {
		this.buttons = buttons;
	}

	public JLabel getInput() {
		return input;
	}

	public void setInput(JLabel input) {
		this.input = input;
	}

	int buttonSize = 70; 
	public ButtonPad(List<ButtonInterface>buttons, JLabel input) {
		this.input=input;
		this.buttons = buttons;
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(new Color(245, 245, 245));
        this.setBorder(BorderFactory.createLineBorder(Color.black, 2,true));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Allow resizing
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1;
        gbc.weighty = 1;

        for (int i = 0; i < buttons.size(); i++) {
            gbc.gridx = i % 3;
            gbc.gridy = i / 3;
            buttons.get(i).setupButton();
            JButton button = buttons.get(i).getButton();
			button.addActionListener(this);
			JLabel lb = new JLabel(Integer.toString(buttons.get(i).getUses()));
			this.add(button,gbc);
			this.add(lb,gbc);

        }

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i =0;i<buttons.size();i++) {
				if(e.getSource()==buttons.get(i).getButton()) {
					String expression= input.getText();
					boolean perform = buttons.get(i).validateExpression(expression);
					if(perform) {
						buttons.get(i).action(this.input);						
						System.out.println(buttons.get(i).getButton().getText()+" got clicked ");
						return ;
					}else {
						JOptionPane.showMessageDialog(null,buttons.get(i).errorMessage()+expression,"Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		}
		
	


	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setPreferredSize(new Dimension(1000,1000));
		f.setLocationRelativeTo(null);
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
		buttons.add( new Equal(2,4,true,new JButton()));
		buttons.add( new Equal(2,4,true,new JButton()));
		buttons.add( new Equal(2,4,true,new JButton()));
		testClass test = new testClass(buttons);
		f.add(test);
		f.setVisible(true);
		f.pack();
	}

}
