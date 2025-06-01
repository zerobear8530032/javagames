package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.MouseInputListener;

import ActionButtons.BackSpace;
import ActionButtons.Equal;
import ButtonInterface.ButtonInterface;
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

public class HomePanel extends JPanel implements MouseInputListener{	
	ImageIcon originalAdventureIcon;
	ImageIcon originalEndlessIcon ;
	ImageIcon originalComingSoonIcon ;
	JLabel adventureLabel;
	JLabel endlessLabel;
	JLabel comingSoonLabel;
	JFrame parentFrame;
	
	public HomePanel(JFrame frame){
		parentFrame = frame;
		this.setBackground(new Color(100,100,123));
		this.setLayout(new GridLayout(1,3));
//		icons :
		
		originalAdventureIcon= new ImageIcon("Images/adventureIcon.jpg");
		originalEndlessIcon = new ImageIcon("Images/endlessIcon.jpg");
		originalComingSoonIcon = new ImageIcon("Images/comingsoonIcon.jpg");
		
//		scaled images
        ImageIcon adventureIcon = new ImageIcon(originalAdventureIcon.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH));
        ImageIcon endlessIcon = new ImageIcon(originalEndlessIcon.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH));
        ImageIcon comingSoonIcon = new ImageIcon(originalComingSoonIcon.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH));
		
//		labels:
		adventureLabel= new JLabel("Adventure Mode");
		adventureLabel.setIcon(adventureIcon);
		adventureLabel.setHorizontalTextPosition(SwingConstants.CENTER); // or SwingConstants.CENTER
		adventureLabel.setVerticalTextPosition(SwingConstants.BOTTOM);   // or SwingConstants.BOTTOM
		adventureLabel.setFont(new Font("",Font.BOLD,25));
		adventureLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		adventureLabel.addMouseListener(this);
		adventureLabel.setBorder(BorderFactory.createLineBorder(Color.black,10,true));
		adventureLabel.setHorizontalAlignment(JLabel.CENTER);
		adventureLabel.setVerticalAlignment(JLabel.CENTER);

		
		endlessLabel= new JLabel("Endless Mode");
		endlessLabel.setIcon(endlessIcon);
		endlessLabel.setHorizontalTextPosition(SwingConstants.CENTER); // or SwingConstants.CENTER
		endlessLabel.setVerticalTextPosition(SwingConstants.BOTTOM);   // or SwingConstants.BOTTOM
		endlessLabel.setFont(new Font("",Font.BOLD,25));
		endlessLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		endlessLabel.addMouseListener(this);
		endlessLabel.setBorder(BorderFactory.createLineBorder(Color.black,10,true));
		endlessLabel.setHorizontalAlignment(JLabel.CENTER);
		endlessLabel.setVerticalAlignment(JLabel.CENTER);
		
		
		comingSoonLabel = new JLabel("Comming Soon");
		comingSoonLabel.setIcon(comingSoonIcon);
		comingSoonLabel.setHorizontalTextPosition(SwingConstants.CENTER); // or SwingConstants.CENTER
		comingSoonLabel.setVerticalTextPosition(SwingConstants.BOTTOM);   // or SwingConstants.BOTTOM
		comingSoonLabel.setFont(new Font("",Font.BOLD,25));
		comingSoonLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		comingSoonLabel.addMouseListener(this);
		comingSoonLabel.setBorder(BorderFactory.createLineBorder(Color.black,5,true));
		comingSoonLabel.setHorizontalAlignment(JLabel.CENTER);
		comingSoonLabel.setVerticalAlignment(JLabel.CENTER);
		
		
		this.add(adventureLabel);
		this.add(endlessLabel);
		this.add(comingSoonLabel);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==adventureLabel) {
			System.out.println("adventurelabel accessed");
			parentFrame.dispose();  // close the old frame
	    	 List<ButtonInterface> buttons = new ArrayList<>();
	          buttons.add(new One(2, 4, true, new JButton()));
	          buttons.add(new Two(2, 4, true, new JButton()));
	          buttons.add(new Three(2, 4, true, new JButton()));
	          buttons.add(new Four(2, 4, true, new JButton()));
	          buttons.add(new Five(2, 4, true, new JButton()));
	          buttons.add(new Six(2, 4, true, new JButton()));
	          buttons.add(new Seven(2, 4, true, new JButton()));
	          buttons.add(new Eight(2, 4, true, new JButton()));
	          buttons.add(new Nine(2, 4, true, new JButton()));
	          buttons.add(new Zero(2, 4, true, new JButton()));
	          buttons.add(new Add(2, 4, true, new JButton()));
	          buttons.add(new Substract(2, 4, true, new JButton()));
	          buttons.add(new Divide(2, 4, true, new JButton()));
	          buttons.add(new Multiply(2, 4, true, new JButton()));
	          buttons.add(new Mod(2, 4, true, new JButton()));
	          buttons.add(new BackSpace(2, 4, true, new JButton()));
	          buttons.add(new Equal(2, 4, true, new JButton()));
	          AdventureFrame  frame= new AdventureFrame(buttons);

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.setSize(new Dimension(1000,1000));
		}
		if(e.getSource()==endlessLabel) {
			System.out.println("endless label accessed");
			parentFrame.dispose();  // close the old frame
			JFrame f = new JFrame("endless");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
			f.setSize(new Dimension(1000,1000));
		}
		if(e.getSource()==comingSoonLabel) {
			System.out.println("comming soon label accessed");
			parentFrame.dispose();  // close the old frame
			JFrame f = new JFrame("comming soon");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
			f.setSize(new Dimension(1000,1000));

		}
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	


	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.add(new HomePanel(f));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setSize(new Dimension(1000,1000));
	}

}
