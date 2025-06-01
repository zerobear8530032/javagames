package ActionButtons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

import ButtonInterface.ActionButtonInterface;

public class BackSpace implements ActionButtonInterface{

	int uses;
	int price;
	boolean usable;
	JButton button;
	@Override
	public  void setupButton() {
		button.setText("Backspace"); 
		button.setPreferredSize(new Dimension(100, 50));
		button.setBorder(BorderFactory.createLineBorder(Color.gray,2, true));
		button.setOpaque(true);
		button.setBackground(new Color(80,0,0));
		button.setForeground(Color.red);
		button.setBorderPainted(true);
		button.setFont(new Font("Roboto Mono", Font.BOLD, 20));
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
	@Override
	public void action(JLabel label) {
		String str= label.getText();
		if(!str.isBlank()) {
			label.setText(str.substring(0,str.length()-1));	
		}
	}
	
	@Override
	public String errorMessage() {
		return "Cannot erase Input its Already Empty ";
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
	public BackSpace(int uses, int price, boolean usable, JButton button) {
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
		if(expression==null) {
			return false;
		}
		if(expression.isBlank()) {
			return false;
		}
		int idx =0;
		char ch = expression.charAt(0);
		if(ch=='-') {
			idx++;
		}
		int n = expression.length();
		while(idx<n) {
			ch = expression.charAt(idx);
			if( ch=='+' || ch=='%' || ch=='*' || ch=='-' || ch=='/') {
				return true;
			}
			idx++;
		}
		return false;
	}
	


}
