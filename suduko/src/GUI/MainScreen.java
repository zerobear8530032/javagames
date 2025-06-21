package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import suduko.generation.GenerateSuduko;

public class MainScreen extends JPanel{
	
	SudukoBoard sudukoPanel;
	ButtonsPanel sudukoButtonPanel;
	public MainScreen(GenerateSuduko generator) {
		this.setLayout(new GridLayout(0,2));
		sudukoPanel= new SudukoBoard(generator);
		sudukoButtonPanel= new ButtonsPanel(sudukoPanel);
		this.add(sudukoButtonPanel);
		this.add(sudukoPanel);
	}
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		GenerateSuduko generator = new GenerateSuduko();
		frame.add(new MainScreen(generator));
		frame.pack();
//		frame.setResizable(false);
	}
}
