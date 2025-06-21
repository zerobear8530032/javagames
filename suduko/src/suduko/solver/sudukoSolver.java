package suduko.solver;

import suduko.generation.GenerateSuduko;

public class sudukoSolver {
	
	public static boolean sudukoSolver(int [][] board) {
		int row=-1;
		int col=-1;
		boolean isEmpty = false;
		for(int i =0;i<board.length;i++) {
			for(int j =0;j<board.length;j++) {
				if(board[i][j]==0) {
					row=i;
					col=j;
					isEmpty=true;
					break;					
				}
			}
			if(isEmpty) {
				break;
			}
		}
		if(isEmpty==false) {
			return true;
		}
		
		for(int i =1;i<=board.length;i++) {
			if(isSafe(board,row,col,i)) {
				int prev= board[row][col];
				board[row][col]=i;
				if(sudukoSolver(board)) {					
					return true;
				}else {
				board[row][col]=prev;			
				}
			}
		}
		
		return false;
	}
	
	public static boolean isSafe(int [][] board, int row , int col , int num) {
//		check row 
		for(int i =0;i<board.length;i++) {
			if(board[row][i]==num) {
				return false;
			}
		}
//		check row 
		for(int i =0;i<board.length;i++) {
			if(board[i][col]==num) {
				return false;
			}
		}
		
//		checkthe subgrind:
		 int sqrt= (int) Math.sqrt(board.length);
		 int r=  row-(row%sqrt);
		 int c=  col-(col%sqrt);
		 for(int i =r;i<r+sqrt;i++) {
			 for(int j= c;j<c+sqrt;j++) {
				 if(board[i][j]==num) {
					 return false;
				 }
			 }
		 }
		
		return true;
	}
	
	
	public static void main(String[] args) {
		
		
		GenerateSuduko generate = new GenerateSuduko();
		int [][] suduko = generate.generateSuduko();
		
		
		
		sudukoSolver(suduko);
		
	}
	

}
