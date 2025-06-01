package ButtonInterface;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public interface ButtonInterface {
	public void action(JLabel label) ;
	public int getUses() ;
	public void setUses(int uses) ;
	public int getPrice() ;
	public void setPrice(int price) ;
	public boolean isUsable() ;
	public void setUsable(boolean usable) ;
	public JButton getButton() ;
	public void setButton(JButton button) ;
//	public ImageIcon getButtonicon() ;
//	public void setButtonicon(ImageIcon buttonicon);
//	public String getIconaddress() ;
//	public void setIconaddress(String iconaddress) ;
//	public ImageIcon getIcon();
//	public void setIcon(ImageIcon icon);
	public  void setupButton();
	public  boolean validateExpression(String expression);
	public  String errorMessage();
}
