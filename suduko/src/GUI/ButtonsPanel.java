package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import suduko.checker.SudukoChecker;
import suduko.checker.SudukoError;
import suduko.generation.GenerateSuduko;
import suduko.solver.sudukoSolver;

public class ButtonsPanel extends JPanel implements ActionListener{
	JButton generate ;
	JButton hint ;
	JButton solve ;
	SudukoBoard sudukoObj;
	JButton validate;
	JButton userSuduko;
	JButton save;
	
	private final  int MAXHINTS=5;
	int HINT =5;

	public ButtonsPanel(SudukoBoard obj) {
		this.sudukoObj=obj;
		this.setLayout(new GridLayout(4,1,100,50));
		this.setPreferredSize(new Dimension(250,100));
		
		generate = new JButton();
		generate.setText("Generate Suduko");
		generate.setBorder(null);
		generate.setFocusable(false);
		generate.setHorizontalTextPosition(SwingConstants.CENTER);
		generate.setPreferredSize(new Dimension(100,25));
		generate.addActionListener(this);
		this.add(generate);

		
		
		hint= new JButton();
		hint.setText("Need a Hint ?");
		hint.setBorder(null);
		hint.setFocusable(false);
		hint.setHorizontalTextPosition(SwingConstants.CENTER);
		hint.setPreferredSize(new Dimension(100,25));
		hint.addActionListener(this);
		this.add(hint);
		
		validate= new JButton();
		validate.setText("Validate Your Solution ?");
		validate.setBorder(null);
		validate.setFocusable(false);
		validate.setHorizontalTextPosition(SwingConstants.CENTER);
		validate.setPreferredSize(new Dimension(100,25));
		validate.addActionListener(this);
		this.add(validate);
		
		solve= new JButton();
		solve.setText("Want Solution ?");
		solve.setBorder(null);
		solve.setFocusable(false);
		solve.setHorizontalTextPosition(SwingConstants.CENTER);
		solve.setPreferredSize(new Dimension(100,25));
		solve.addActionListener(this);
		this.add(solve);
		
		userSuduko= new JButton();
		userSuduko.setText("Wana Create Your Own ?");
		userSuduko.setBorder(null);
		userSuduko.setFocusable(false);
		userSuduko.setHorizontalTextPosition(SwingConstants.CENTER);
		userSuduko.setPreferredSize(new Dimension(100,25));
		userSuduko.addActionListener(this);
		this.add(userSuduko);
		
		save= new JButton();
		save.setText("Save ");
		save.setBorder(null);
		save.setFocusable(false);
		save.setHorizontalTextPosition(SwingConstants.CENTER);
		save.setPreferredSize(new Dimension(100,25));
		save.addActionListener(this);
		save.setEnabled(false);
		this.add(save);
	}
	
	public void clearBoard(JTextField [][] fields) {
		for(int i =0;i<fields.length;i++) {
			for(int  j=0;j<fields.length;j++) {
				JTextField textField= fields[i][j];
				textField.setText("");
				textField.setBackground(Color.gray);
				textField.setEditable(true);
				textField.setInputVerifier(new SudukoTextVerifier());
			}
		}
	}
	public void clearBoard(int  [][]board) {
		for(int i =0;i<board.length;i++) {
			for(int  j=0;j<board.length;j++) {
				board[i][j]=0;
			}
		}
	}
	
	public void clearBoard(int  [][]board, JTextField [][]fields  , int [][] solution) {
		for(int i =0;i<fields.length;i++) {
			for(int  j=0;j<fields.length;j++) {
				JTextField textField= fields[i][j];
				textField.setText("");
				textField.setBackground(Color.gray);
				textField.setEditable(true);
				textField.setInputVerifier(new SudukoTextVerifier());
				board[i][j]=0;
				solution[i][j]=0;
			}
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==solve) {
			System.out.println("Solve is working !");
			int [][] sudukoresult= sudukoObj.getSolution();
			JTextField [][]fields = sudukoObj.getBoardTextFields();
			int [][] currboard = sudukoObj.getBoard();
			for(int i =0;i<fields.length;i++) {
				for(int j=0;j<fields[i].length;j++) {
					currboard[i][j]=sudukoresult[i][j];
					String res= Integer.toString(sudukoresult[i][j]) ;	
					JTextField field =fields[i][j];
					field.setText(res);
					field.setBackground(Color.white);
					field.setInputVerifier(null);
					field.setEditable(false);
				}
			}
		}
		if(e.getSource()==hint) {
			System.out.println("Hint is working !");
			if(HINT==0) {
				return;
			}			
			boolean donehelp=false;
			int [][] sudukoresult= sudukoObj.getSolution();
			JTextField [][]fields = sudukoObj.getBoardTextFields();
			int [][] currboard = sudukoObj.getBoard();
			for(int i =0;i<fields.length;i++) {
				for(int j=0;j<fields[i].length;j++) {
					if(currboard[i][j]!=sudukoresult[i][j]) {
						donehelp=true;
						currboard[i][j]=sudukoresult[i][j];
						String res= Integer.toString(sudukoresult[i][j]) ;	
						JTextField field =fields[i][j];
						field.setText(res);
						field.setEditable(false);
						field.setBackground(Color.white);
						field.setInputVerifier(null);
						break;
					}
				}
				if(donehelp) {
					break;
				}
			}
			HINT--;
			if(HINT==0) {
				System.out.println("Hint you are out of Hints ");
				hint.setEnabled(false);
			}
		}
		if(e.getSource()==validate) {			
			System.out.println("Validate is Running ");
			int [][] currboard = sudukoObj.getBoard();
			JTextField [][]fields= sudukoObj.getBoardTextFields();
			updateBoard(currboard,fields);
			List<SudukoError> errors=SudukoChecker.checkSolution(currboard);
			boolean res = false;
			if(errors.size()==0) {
				res=true;
			}
			if(res) {
				JOptionPane.showMessageDialog(null, "Solved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
				sudukoObj.reset();
			}else {
				sudukoObj.highlightErrors(errors);
			}
		}
		if(e.getSource()==generate) {
			HINT=MAXHINTS;
			hint.setEnabled(true);
			sudukoObj.reset();			
		}
		if(e.getSource()==userSuduko) {
			System.out.println("User Creating Suduko");
			HINT=MAXHINTS;			
			save.setEnabled(true);
			this.validate.setText("Validate Your Suduko");
			generate.setEnabled(false);
			hint.setEnabled(false);
			userSuduko.setEnabled(false);
			solve.setEnabled(false);
		
			int [][] sudukoresult= sudukoObj.getSolution();
			JTextField [][]fields = sudukoObj.getBoardTextFields();
			int [][] currboard = sudukoObj.getBoard();
			clearBoard(sudukoresult, fields, currboard);
		}
		if(e.getSource()==save) {
			System.out.println("Save pressed");
			this.validate.setText("Validate Your Solution");
			save.setEnabled(false);
			int [][] currboard = sudukoObj.getBoard();
			JTextField [][]fields= sudukoObj.getBoardTextFields();
			int [][]solution= sudukoObj.getSolution();
			updateBoard(currboard,fields);
			List<SudukoError> errors=SudukoChecker.checkSolution(currboard);
			boolean res = true;
			for(SudukoError error:errors) {
				if(!error.getType().equals("empty")) {
					res=false;
				}
			}
			if(res) {
				generate.setEnabled(true);
				hint.setEnabled(true);
				userSuduko.setEnabled(true);
				solve.setEnabled(true);
				updateBoard(currboard,solution,fields);
				sudukoSolver solver = new sudukoSolver();
				solver.sudukoSolver(solution);
				sudukoObj.setSolution(solution);
			}else {
				sudukoObj.highlightErrors(errors);
			}
		}
	}
	
	public static void updateBoard(int [][] board, JTextField [][] fields) {
		for(int i =0;i<fields.length;i++) {
			for(int j =0;j<fields[i].length;j++) {
				if(fields[i][j].getText().isBlank()) {
					board[i][j]=0;
				}else {
					String num = fields[i][j].getText();
					int x= Integer.parseInt(num);
					board[i][j]=x;
				}
			}
		}
	}
	public static void updateBoard(int [][] board,int [][] solution ,JTextField [][] fields) {
		for(int i =0;i<fields.length;i++) {
			for(int j =0;j<fields[i].length;j++) {
				if(fields[i][j].getText().isBlank()) {
					board[i][j]=0;
				}else {
					String num = fields[i][j].getText();
					int x= Integer.parseInt(num);
					board[i][j]=x;
					solution[i][j]=x;
				}
			}
		}
	}
//	
//	public static void main(String[] args) {
////		JFrame frame = new JFrame();
////		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		frame.setVisible(true);
////		frame.setLocationRelativeTo(null);
////		frame.setPreferredSize(new Dimension(500,500));
////		GenerateSuduko generator = new GenerateSuduko();
////		int [][] suduko = generator.generateSuduko();
////		generator.removeRandomElements(suduko);
////		frame.add(new ButtonsPanel(null));
////		frame.pack();
////		frame.setResizable(false);
//	}
}
