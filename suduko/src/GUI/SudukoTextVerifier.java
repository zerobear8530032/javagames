package GUI;

import java.awt.Color;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class SudukoTextVerifier extends InputVerifier {
	@Override
	public boolean verify(JComponent input) {
	    JTextField tf = (JTextField) input;
	    String text = tf.getText().trim();

	    if (text.isEmpty()) {
	        tf.setBackground(Color.gray);
	        return true;
	    }

	    try {
	        int val = Integer.parseInt(text);
	        if (val >= 1 && val <= 9) {
	            tf.setBackground(Color.gray);
	            return true;
	        }
	    } catch (NumberFormatException e) {}

	    tf.setBackground(Color.PINK);
	    return false;
	}

	
	  @Override
	    public boolean shouldYieldFocus(JComponent input) {
	        boolean valid = verify(input);
	        if (!valid) {
	            ((JTextField) input).setText(""); // Clear invalid input
	        }
	        return valid;
	    }
	  
	  

}
