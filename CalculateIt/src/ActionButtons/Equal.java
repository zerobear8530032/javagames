package ActionButtons;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Random;
import javax.swing.JLabel;

import ButtonInterface.ActionButtonInterface;
import GUI.AdventureFrame;
import GUI.BackgroundPanel;

public class Equal implements ActionButtonInterface{

	int uses;
	int price;
	boolean usable;
	JButton button;
	@Override
	public  void setupButton() {
		button.setText("="); 
		button.setPreferredSize(new Dimension(100, 50));
		button.setBorder(BorderFactory.createLineBorder(Color.gray,2, true));
		button.setOpaque(true);
		button.setBackground(new Color(0,120,215));
		button.setForeground(Color.WHITE);
		button.setBorderPainted(true);
		button.setFont(new Font("Roboto Mono", Font.BOLD, 20));

	}
	JLabel inputlabel;
	JLabel target ;
	Random rand ;
	BackgroundPanel background ;
	AdventureFrame adventureFrame;

	
	
	@Override
	public String errorMessage() {
		return "Expression is not Valid to Proceed ! ";
	}
	
//	@Override	
//	public String getIconaddress() {
//		return iconaddress;
//	}
//	@Override
//	public void setIconaddress(String iconaddress) {
//		this.iconaddress = iconaddress;
//	}
//	@Override
//	public ImageIcon getIcon() {
//		return icon;
//	}
//	@Override
//	public void setIcon(ImageIcon icon) {
//		this.icon = icon;
//	}
	
	public BackgroundPanel getBackGroundPanel() {
		return background;
	}

	public void setBackGroundPanel(BackgroundPanel background) {
		this.background = background;
	}

	public JLabel getInputlabel() {
		return inputlabel;
	}
	
	public void setAdventure(AdventureFrame adventureFrame) {
		this.adventureFrame = adventureFrame;
	}
	
	public AdventureFrame getadventureFrame() {
		return adventureFrame;
	}

	public void setInputlabel(JLabel inputlabel) {
		this.inputlabel = inputlabel;
	}

	public JLabel getTarget() {
		return target;
	}

	public void setTarget(JLabel target) {
		this.target = target;
	}

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}
	
	public Equal() {
		rand= new Random();
		}
	
  
    public int generateNumber(int target) {
    	int num= rand.nextInt(1, 300);
    	while(target==num) {
    		num= rand.nextInt();
    	}
    	return num;
    }
    
    public int generateNumber(int s, int e, int target) {
    	int num= rand.nextInt(s,e);
    	while(target==num) {
    		num= rand.nextInt();
    	}
    	return num;
    }

    
	public  boolean isWin(JLabel target , JLabel input) {
		return target.getText().equals(input.getText());
	}
    
	
	@Override
	public void action(JLabel label) {
		
		String expression = label.getText();
		StringBuilder first = new StringBuilder();
		StringBuilder second= new StringBuilder();
		int idx=0;
		int n = expression.length();
		char operator=' ';
			if(expression.charAt(0)=='-') {
				first.append('-');
				idx++;
			}
			while(idx<n && isCharacter(expression.charAt(idx))) {
				first.append(expression.charAt(idx));
				idx++;
			}
			operator =expression.charAt(idx);
			idx++;
			while(idx<n && isCharacter(expression.charAt(idx))) {
				second.append(expression.charAt(idx));
				idx++;
			}
			
		long f= Long.parseLong(first.toString());
		long s= Long.parseLong(second.toString());
		String res="";
		if(operator=='+') {
			res=Long.toString(f+s);
		}else if(operator=='-') {
	
			res=Long.toString(f-s);			
		}
		else if(operator=='/') {
			if(s==0) return;
			res=Long.toString(f/s);			
		}else if(operator=='*') {
			res=Long.toString(f*s);			
		}else if(operator=='%') {
			if(s==0) return;
			res=Long.toString(f%s);			
		}
		label.setText(res);
		if(isWin(target,inputlabel)) {
			adventureFrame.startRound();
		}
		background.repaint();
		
	}
	public static boolean isCharacter(char ch) {
		return (ch>='0') && (ch<='9');
	}
	@Override
	public int getUses() {
		return this.uses;
	}
	@Override
	public void setUses(int uses) {
		this.uses= uses;	
	}
	@Override
	public int getPrice() {
		return this.price;
	}
	@Override
	public void setPrice(int price) {
		this.price=price;
	}
	@Override
	public boolean isUsable() {
		return this.usable;
	}
	@Override
	public void setUsable(boolean usable) {
		this.usable=usable;
	}
	@Override
	public JButton getButton() {
		return button;
	}
	@Override
	public void setButton(JButton button) {
		this.button=button;
	}
	public Equal(int uses, int price, boolean usable, JButton button) {
		this.uses = uses;
		this.price = price;
		this.usable = usable;
		this.button = button;
	}
//	@Override
//	public String toString() {
//		return "One [uses=" + uses + ", price=" + price + ", usable=" + usable + ", button=" + button + ", iconaddress="
//				+ iconaddress + ", icon=" + icon + "]";
//	}
	@Override
	public String toString() {
		return "One [uses=" + uses + ", price=" + price + ", usable=" + usable + ", button=" + button +  "]";
	}	
	
	@Override
	public boolean validateExpression(String expression) {
		if(expression== null) {
			return false;
		}
		if(expression.isBlank()) {
			return false;
		}
		char ch = expression.charAt(expression.length()-1);
		if(ch=='+' || ch=='/' || ch=='-' || ch=='*' || ch=='%') {
			return false;
		}else {
			int count=0;
			for(int i =0;i<expression.length();i++) {
				ch= expression.charAt(i);
				if(ch=='+' || ch=='/' || ch=='-' || ch=='*' || ch=='%') {
					count++;
				}		
			}
			return count<2 && count!=0 ;
		}
		
		
		
		
	}

	
	


}
