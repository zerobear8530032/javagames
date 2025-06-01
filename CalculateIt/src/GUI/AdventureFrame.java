package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
import Rounds.Rounds;
public class AdventureFrame extends JFrame {
    BackgroundPanel background;
    CalculatorBody body;
    Random rand;
    List<ButtonInterface> buttons;
    JLabel  money ;
    JLabel  round ;
    int maxRound ;
    Rounds r ;
    JLabel target;
    
    public void startRound() {
    	int x= r.generateRandom();
    	int [] pair =r.getRound(x);
    	int inital =pair[0];
    	int t = pair[1];

    	body.inputbox.input.setText(Integer.toString(inital));
    	this.target.setText(Integer.toString(t));
    	int nextround= Integer.parseInt(round.getText());
    	nextround++;
    	round.setText(nextround+"");
    	int bal= Integer.parseInt(money.getText());
    	bal+=5;
    	money.setText(bal+"");
    	if(nextround>maxRound) {
    		JOptionPane.showInternalMessageDialog(null, null, "You Win", JOptionPane.INFORMATION_MESSAGE);
    	}
    	
    }
    
    
    
    public  boolean isWin(JLabel target , JLabel input) {
    	return target.getText().equals(input.getText());
    }
    
    public AdventureFrame(List<ButtonInterface> buttons) {
    	r= new Rounds();
    	this.buttons=buttons;
    	rand = new Random() ;
        setTitle("Calculator Adventure");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        target= new JLabel();
        target.setVisible(false);
        this.add(target);

        money = new JLabel("0");
        round = new JLabel("0");
        this.maxRound=20;
      
        body = new CalculatorBody(buttons);
        body.setOpaque(false);
        // 👇 Wrap in a container with fixed preferred size
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setOpaque(false);
        wrapper.setPreferredSize(new Dimension(500, 600)); // Limit body size
        wrapper.add(body, BorderLayout.CENTER);

        background = new BackgroundPanel(body.inputbox.getInput(),target,money,round,maxRound);
        setContentPane(background); // Full background

        background.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        background.add(wrapper, gbc);
        setVisible(true);
        
        
        for(ButtonInterface button:buttons) {
        	  if (button instanceof Equal) {
        		  Equal equalButton = (Equal) button;
        		  equalButton.setTarget(target);
        		  equalButton.setInputlabel(body.inputbox.getInput());
        		  equalButton.setRand(rand);
        		  equalButton.setBackGroundPanel(background);
        		  equalButton.setAdventure(this);
        	  } 	       
        }
   
        startRound();
        
    }
    
  
    
    public static boolean isNumber(char ch) {
    	return ch>='0' && ch<='9';
    }
    
    public static void main(String[] args) {
    	 List<ButtonInterface> buttons = new ArrayList<>();
          buttons.add(new One(0, 4, true, new JButton()));
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
          new AdventureFrame(buttons);
    }
}
