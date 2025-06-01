package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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

public class testClass  extends JPanel implements ActionListener{
	
	
	
	List<ButtonInterface> matrix;
	JLabel input = new JLabel("56");

	public testClass(List<ButtonInterface>matrix) {
		this.matrix=matrix;
		this.setPreferredSize(new Dimension(1000,1000));
		this.setLayout(new GridLayout(3,3));
		for(int i =0;i<matrix.size();i++) {
				matrix.get(i).setupButton();
				JButton button = matrix.get(i).getButton();
				button.addActionListener(this);
				this.add(button);
				}
		this.setBorder(BorderFactory.createLineBorder(Color.white, 5, true));
		input.setPreferredSize(new Dimension(100,100));
		this.add(input);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i =0;i<matrix.size();i++) {
				if(e.getSource()==matrix.get(i).getButton()) {
					String expression= input.getText();
					boolean perform = matrix.get(i).validateExpression(expression);
					if(perform) {
						matrix.get(i).action(this.input);						
						System.out.println(matrix.get(i).getButton().getText()+" got clicked ");
						return ;
					}else {
						JOptionPane.showMessageDialog(null,"Their a problem in Expression please fix it ! "+expression,"Warning", JOptionPane.WARNING_MESSAGE);
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
		testClass test = new testClass(buttons);
		f.add(test);
		f.setVisible(true);
		f.pack();
	}

}
