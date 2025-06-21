package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.InputMethodListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.Timer;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import suduko.checker.SudukoError;
import suduko.generation.GenerateSuduko;

public class SudukoBoard extends JPanel{
	
	JTextField [][] boardTextFields;
	int [][] board;
	int [][] solution;
	GenerateSuduko sudukoGenerator;
	
	
	
	public void highlightErrors(List<SudukoError> errors) {
	    for (SudukoError error : errors) {
	        int i = error.getRow();
	        int j = error.getCol();
	        JTextField field = boardTextFields[i][j];
	        Color originalColor = field.getBackground();
	        if(error.getType().equalsIgnoreCase("empty")) {
	        	field.setBackground(Color.orange);	        	
	        }else {
	        	field.setBackground(Color.RED);	        	
	        }
	        Timer timer = new Timer(1000, e -> field.setBackground(originalColor));
	        timer.setRepeats(false);
	        timer.start();
	    }
	}

	public SudukoBoard(GenerateSuduko sudukoGenerator) {
		this.sudukoGenerator=sudukoGenerator;
		this.board= sudukoGenerator.generateSuduko();
		
		solution=sudukoGenerator.getCopy();
		sudukoGenerator.removeRandomElements(board);
		int r=board.length;
		int c=board[0].length;
		this.setLayout(new GridLayout(r,c));
		this.setPreferredSize(new Dimension(500,500));
		this.boardTextFields = new JTextField[r][c];
		for(int i =0;i<r;i++) {
			for(int j =0;j<c;j++) {
				JTextField textField = new JTextField();
				boardTextFields[i][j]=textField;
				textField.setPreferredSize(new Dimension(50,50));
				textField.setBorder(BorderFactory.createLineBorder(Color.black));
				textField.setFont(new Font("Times new Romain", Font.BOLD, 25));
				textField.setHorizontalAlignment(JTextField.CENTER);
				if(board[i][j]!=0) {
					textField.setBackground(Color.WHITE);
			 		textField.setText(Integer.toString(board[i][j]));
					textField.setEditable(false);					
				}else {					
					textField.setBackground(Color.gray);
					textField.setInputVerifier(new SudukoTextVerifier());
				}
				this.add(textField);
			}
		}
		
	}
	
	
	
	
	
	
	public JTextField[][] getBoardTextFields() {
		return boardTextFields;
	}
	
	
	
	
	public void setBoardTextFields(JTextField[][] boardTextFields) {
		this.boardTextFields = boardTextFields;
	}




	public int[][] getBoard() {
		return board;
	}




	public void setBoard(int[][] board) {
		this.board = board;
	}
	
	public int[][] getSolution() {
		return solution;
	}
	
	
	
	
	public void setSolution(int[][] board) {
		this.solution = board;
	}

	public GenerateSuduko getSudukoGenerator() {
		return sudukoGenerator;
	}




	public void setSudukoGenerator(GenerateSuduko sudukoGenerator) {
		this.sudukoGenerator = sudukoGenerator;
	}

	public void reset() {
	    // Generate a new board and solution
	    this.board = sudukoGenerator.generateSuduko();
	    this.solution = sudukoGenerator.getCopy();
	    sudukoGenerator.removeRandomElements(board);

	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[0].length; j++) {
	            JTextField textField = boardTextFields[i][j];

	            if (board[i][j] != 0) {
	                textField.setText(Integer.toString(board[i][j]));
	                textField.setEditable(false);
	                textField.setForeground(Color.BLACK);
	                textField.setBackground(Color.white);
	            } else {
	                textField.setText("");
	                textField.setBackground(Color.gray);
	                textField.setEditable(true);
	                textField.setInputVerifier(new SudukoTextVerifier());
	            }
	        }
	    }

	    // Optional: repaint the board to ensure updates are reflected
	    this.revalidate();
	    this.repaint();
	}



//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//		frame.setLocationRelativeTo(null);
//		frame.setPreferredSize(new Dimension(500,500));
//		GenerateSuduko generator = new GenerateSuduko();
//		frame.add(new SudukoBoard(generator));
//		frame.pack();
//		frame.setResizable(false);
//		int [][] board= generator.getCopy();
//		
//		for(int [] rows:board) {
//			System.out.println(Arrays.toString(rows));
//		}
//}




}
