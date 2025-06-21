package suduko.checker;

public class SudukoError {
	
	
	String type;
	int row;
	int col;
	int noofEmptyErrors = 0;
	int noofIncorrectErrors = 0;
	
	public SudukoError(String type, int row, int col) {
		if(type.equals("empty")) {
			noofEmptyErrors ++;
		}else {
			noofIncorrectErrors++;	
		}
		this.type = type;
		this.row = row;
		this.col = col;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getCol() {
		return col;
	}


	public void setCol(int col) {
		this.col = col;
	}
	
	
	
	
	


	public int getNoofEmptyErrors() {
		return noofEmptyErrors;
	}


	public void setNoofEmptyErrors(int noofEmptyErrors) {
		this.noofEmptyErrors = noofEmptyErrors;
	}


	public int getNoofIncorrectErrors() {
		return noofIncorrectErrors;
	}


	public void setNoofIncorrectErrors(int noofIncorrectErrors) {
		this.noofIncorrectErrors = noofIncorrectErrors;
	}


	@Override
	public String toString() {
		return "SudukoError [type=" + type + ", row=" + row + ", col=" + col + "]";
	}


	public static void main(String[] args) {
		
	}
	

}
