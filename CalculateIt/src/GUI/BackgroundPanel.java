package GUI;
import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {

	    private Image backgroundImage;
	    JLabel  input, target;
	    private Image frame;
	    JLabel  money ;
	    JLabel  round ;
	    
	    
	    public Image getBackgroundImage() {
			return backgroundImage;
		}

		public void setBackgroundImage(Image backgroundImage) {
			this.backgroundImage = backgroundImage;
		}

		public JLabel getInput() {
			return input;
		}

		public void setInput(JLabel input) {
			this.input = input;
		}

		public JLabel getTarget() {
			return target;
		}

		public void setTarget(JLabel target) {
			this.target = target;
		}

		public Image getFrame() {
			return frame;
		}

		public void setFrame(Image frame) {
			this.frame = frame;
		}

		public JLabel getMoney() {
			return money;
		}

		public void setMoney(JLabel money) {
			this.money = money;
		}

		public JLabel getRound() {
			return round;
		}

		public void setRound(JLabel round) {
			this.round = round;
		}

		public int getMax() {
			return max;
		}

		public void setMax(int max) {
			this.max = max;
		}



		int max ;
	    public BackgroundPanel(JLabel input, JLabel target, JLabel money, JLabel round, int max) {
	    	this.input=input;
	    	this.target=target;
	    	this.money=money;
	    	this.round=round;
	    	this.max=max;
	        // Load the background image
	        backgroundImage = new ImageIcon("Images/mainbackground.jpg").getImage();
	        frame = new ImageIcon("Images/frame.jpg").getImage();
	        // Allow layout for children
	        setLayout(new BorderLayout());
	    }

	    // Paint the background image
	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        if (backgroundImage != null) {
	            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	        }
	    }
	    
	    
	    @Override
	    public void paint(Graphics g) {
	    	

	        Graphics2D g2d = (Graphics2D) g;
	        super.paint(g2d);
	        
            g.drawImage(frame, 25, 25, 250, 200, this);
            g.setFont(new Font ("Times new Roman",Font.BOLD,25));
            g.setColor(new Color(63,114,57));  // Optional: better contrast if over image
            g.drawString("Money : "+money.getText(), 60, 100); // Place inside or just below the image            
            g.drawString("Round : "+round.getText()+"/"+max, 60, 125); // Place inside or just below the image
            

	        
	        int diameter = 250; 
	        int x = getWidth() -200;  // right margin
	        int y = getHeight() -200; // bottom margin
	        
	        // Draw the circle
	        g2d.setColor(Color.white);
	        g2d.fillOval(x, y, diameter, diameter);

	        // Draw the input text centered in the circle
	        StringBuilder str= new StringBuilder();
	        
	        String inputText = input.getText();
	        int idx =0;
	        if(inputText.charAt(idx)=='-') {
	        	str.append(inputText.charAt(idx));
	        	idx++;
	        }
	        
	        while(idx<inputText.length() && isNumber(inputText.charAt(idx))) {
	        	str.append(inputText.charAt(idx));
	        	idx++;
	        }
	        inputText=str.toString();

	        g2d.setColor(Color.gray);
	        g2d.setFont(new Font("SansSerif", Font.BOLD, 25));
	        FontMetrics fm = g2d.getFontMetrics();

	        // Calculate centered position
	        int textWidth = fm.stringWidth(inputText);
	        int textHeight = fm.getAscent();

	        int centerX = x + diameter / 2 - textWidth / 2;
	        int centerY = y + diameter / 2 + textHeight / 4; // vertical center adjusted for baseline
	        g2d.drawString(inputText, centerX, centerY);
	        
	        g2d.setColor(new Color(125,125,125));
	        x=x+100;
	        y=y-50;
	        diameter=diameter/2;
	        g2d.fillOval(x, y, diameter, diameter);
	        g2d.setColor(Color.white);
	        centerX = x + diameter / 2 - textWidth / 2;
	        centerY = y + diameter / 2 + textHeight / 4; // vertical center adjusted for baseline
	        String targetText = target.getText();
	        
	        g2d.drawString(targetText, centerX, centerY);
	    

	        
	    }
	    
	    
	    
	    public static boolean isNumber(char ch) {
	    	return ch>='0' && ch<='9';
	    }
	    	    

	    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Full Background Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize window
        frame.setUndecorated(false); // Set to true if you want borderless fullscreen

        frame.add(new BackgroundPanel(new JLabel("123"), new JLabel("342"), new JLabel("3434 $"), new JLabel("1"),20), BorderLayout.CENTER);
        frame.setVisible(true);

    }
}
