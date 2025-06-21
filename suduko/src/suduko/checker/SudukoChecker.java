package suduko.checker;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import suduko.generation.GenerateSuduko;

public class SudukoChecker {
	
	
	
	public static boolean validSuduko(int [][] board) {
		for(int i =0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				if(board[i][j]==0) {
					return validatePartiallyFilledSudoku(board);			
				}
			}
		}
			return validateFullyFilledSudoku(board);
	}
	
	public  static List<SudukoError> checkSolution(int [][] board){
		List<SudukoError> errors = new ArrayList<SudukoError>();
		for(int i=0;i<board.length;i++) {
			for(int j =0;j<board.length;j++) {
				int num= board[i][j];				
				if(board[i][j]==0) {
					SudukoError error = new SudukoError("empty",i,j);
					errors.add(error);
					continue;
				}
				boolean safe= isSafe(board,i,j,num);
				if(!safe) {
					SudukoError error = new SudukoError("incorrect",i,j);
					errors.add(error);					
				}
			}
		}
		return errors;
	}
	
	
	
	public static boolean validatePartiallyFilledSudoku(int [][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j =0;j<board.length;j++) {
				int num= board[i][j];
				if(board[i][j]==0) {
					continue;
				}
				boolean safe= isSafe(board,i,j,num);
				if(safe==false) {
					return false;
				}
			}
		}
		return true;
		
	}
	public static boolean validateFullyFilledSudoku(int [][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j =0;j<board.length;j++) {
				int num= board[i][j];
				boolean safe= isSafe(board,i,j,num);
				if(safe==false) {
					return false;
				}
			}
		}
		return true;
		
	}
	public static boolean isSafe(int [][] board, int row , int col ,int num) {
		if(num<=0  || num>9) {
			return false;
		}
		// check entire row check entire column:
		for(int i =0;i<board.length;i++) {
			if(col==i) continue;
			if(board[row][i]==num) {
				return false;
			}
		}
		// check entire cols :
		for(int i=0;i<board.length;i++) {
			if(row==i) continue;
			if(board[i][col]==num) {
				return false;
			}
		}
		// check 3*3 grid:
		int sqrt=(int) Math.sqrt(board.length);
		int r= row-(row%sqrt);
		int c= col-(col%sqrt);
		for(int i =r;i<r+sqrt;i++){
			for(int j=c;j<c+sqrt;j++) {
				if(i==row && col==j) {
					continue;
				}
				if(board[i][j]==num) {
					return false;
				}
			}
		}
		return true;
	}
	
	

	public static void main(String[] args) {
		
		GenerateSuduko suduko = new GenerateSuduko();
		int[][] sudukoboard= suduko.generateSuduko();
		for(int [] row:sudukoboard) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println(validSuduko(sudukoboard));
		sudukoboard[3][3]=33;
		System.out.println(validSuduko(sudukoboard));
		sudukoboard[3][3]=0;
		System.out.println(validSuduko(sudukoboard));

	}

}
