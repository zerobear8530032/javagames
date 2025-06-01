package ButtonInterface;

import javax.swing.JButton;
import javax.swing.JLabel;

public interface NumberButtonInterface  extends ButtonInterface{
	default public boolean validateExpression(String expression) {
		int idx=0;
		if(expression== null) {
			return false;
		}
		if(expression.isBlank()) {
			return false;
		}
		int n = expression.length();
	
		
		char ch = expression.charAt(idx);
		if(ch=='+' || ch=='-') {
			idx++;
		}
		
		
		
		
		while(idx<n) {
			char character = expression.charAt(idx);
			if(!(character>='0' && character<='9')) {
				return true;
			}
			idx++;
		}
		return false;
	}
	default public String errorMessage() {
		return "Enter a Valid Operator First !";
	}

}
