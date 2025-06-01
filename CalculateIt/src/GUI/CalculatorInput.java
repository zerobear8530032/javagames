package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorInput extends JPanel {	
	JLabel input;
	public  CalculatorInput() {
		input= new JLabel("");
		this.setLayout(new BorderLayout());
		input.setForeground(Color.WHITE);
		this.setBackground(Color.GRAY);
	    this.setBorder(BorderFactory.createLineBorder(Color.white,5));
		input.setFont(new Font("Times New Roman", Font.BOLD,25));
		this.add(input,BorderLayout.EAST);
	}
	
	
	
	public JLabel getInput() {
		return input;
	}



	public void setInput(JLabel input) {
		this.input = input;
	}



	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.add(new CalculatorInput());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setSize(new Dimension(1000,1000));
		f.pack();
	}

}
