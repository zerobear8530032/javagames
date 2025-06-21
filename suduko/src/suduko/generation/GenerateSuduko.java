package suduko.generation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import suduko.checker.SudukoChecker;
import suduko.solver.sudukoSolver;
import GUI.SudukoTextVerifier;


public class GenerateSuduko  {
	
	
	
	private static Random ran;
	int [][] copyboard;
	
	public GenerateSuduko() {
		ran = new Random();
	}
	
	public static  void removeRandomElements(int [][] board) {
		int n = board.length;
		int totalElement = n*n;
		int noElementRemove = ran.nextInt(70,80) ;
		for(int i =0;i<noElementRemove;i++) {
			int row = ran.nextInt(0,9);
			int col = ran.nextInt(0,9);
			board[row][col]=0;
		}
	}
	
	
	public int [][] generateSuduko( ){
		int [][] board= new int[9][9];		
		generate(board);
		return board;
	}
	
	public boolean  generate(int [][] board) {	
		int r=-1;
		int c=-1;
		boolean isEmpty=false;
		for(int i =0;i<board.length;i++) {
			for(int j =0;j<board.length;j++) {
				if(board[i][j]==0) {
					r=i;
					c=j;
					isEmpty=true;
					break;
				}
			}
			if(isEmpty) {
				break;
			}
		}
		if(isEmpty==false) {
			this.copyboard=createCopy(board);
			return true;
		}
		List<Integer> validIntegers=getValidNumbers(board,r,c ); 
		while(validIntegers.size()!=0) {
			int tryNum = getRandomNumber(validIntegers);
			validIntegers.remove(Integer.valueOf(tryNum));
			int prev= board[r][c];
			board[r][c]=tryNum;			
			if(generate(board)) {
				return true;
			}else {
				board[r][c]=prev;				
			}
		}
		
		return false;
	}
	
	public List<Integer> getValidNumbers(int [][] board, int row, int col) {	
		List<Integer> canput = new ArrayList<>();
		for(int i =1;i<=9;i++) {
			if(isSafe(board,row,col,i)) {
				canput.add(i);
			}
		}
		return canput;
	}
	
	public  boolean isSafe(int [][] board,int row , int col , int num) {
		// check entire row check entire column:
		for(int i =0;i<board.length;i++) {
			if(board[row][i]==num) {
				return false;
			}
		}
		// check entire cols :
		for(int rows []: board) {
			if(rows[col]==num) {
				return false;
			}
		}
		// check 3*3 grid:
		int sqrt=(int) Math.sqrt(board.length);
		int r= row-(row%sqrt);
		int c= col-(col%sqrt);
		for(int i =r;i<r+sqrt;i++){
			for(int j=c;j<c+sqrt;j++) {
				if(board[i][j]==num) {
					return false;
				}
			}
		}
		return true;
	}
	
	public  int [][] getCopy(){
		int [][] copy = new int[this.copyboard.length][this.copyboard[0].length];
		for(int i=0;i<copy.length;i++) {
			for(int j =0;j<copy[0].length;j++) {
				copy[i][j]=copyboard[i][j];
			}
		}
		return copy;
	}
	
	
	private  int [][] createCopy(int [][]board){
		int [][] copy = new int[board.length][board[0].length];
		for(int i=0;i<copy.length;i++) {
			for(int j =0;j<copy[0].length;j++) {
				copy[i][j]=board[i][j];
			}
		}
		return copy;
	}
	
	public  int getRandomNumber(List<Integer> list) {
		if(list.size()==0) {
			return -1;
		}
		int generateidx = ran.nextInt(0,list.size());
		return list.get(generateidx);
	}
	
	
	
	
	public static void main(String[] args) {
		GenerateSuduko sudo= new GenerateSuduko();
		int [][] suduko = sudo.generateSuduko();
		sudo.removeRandomElements(suduko);
		System.out.println("Inital :");
		for(int [] row:suduko) {
			System.out.println(Arrays.toString(row));
		}
	
		System.out.println("Solved :");
		sudukoSolver solver = new sudukoSolver();
		solver.sudukoSolver(suduko);
		for(int [] row:suduko) {
			System.out.println(Arrays.toString(row));
		}
		SudukoChecker checker = new SudukoChecker();
		System.out.println(checker.validSuduko(suduko));
	}
	
	

}
