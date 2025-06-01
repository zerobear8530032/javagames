package NumberButtons;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ButtonInterface.ButtonInterface;
import ButtonInterface.NumberButtonInterface;
public class Three implements NumberButtonInterface{
	
	int uses;
	int price;
	boolean usable;
	JButton button;
	
	@Override
	public  void setupButton() {
		button.setText("3"); 
		button.setPreferredSize(new Dimension(100, 50));
		button.setBorder(BorderFactory.createLineBorder(Color.gray,2, true));
		button.setOpaque(true);
		button.setBackground(new Color(40,40,40));
		button.setForeground(Color.white);
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
		if(uses==0) {
			JOptionPane.showMessageDialog(null,"Sorry But You Have No Uses Left ! ");
		}else {			
		String str= label.getText();
		label.setText(str+'3');
		this.uses--;
		}
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
	public Three(int uses, int price, boolean usable, JButton button) {
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
}
