package ButtonInterface;

public interface OperatorButtonInterface extends ButtonInterface{
	default public boolean validateExpression(String expression) {
		if(expression== null) {
			return false;
		}
		if(expression.isBlank()) {
			return false;
		}
		int n = expression.length();
		int idx =0;
		char ch =expression.charAt(0);
		if(ch=='-') {
			idx++;
		}
		while(idx<n) {
			ch = expression.charAt(idx);
			if(ch=='+' || ch =='/' || ch=='-' || ch =='%' || ch =='*') {
				return false;
			}	
			idx++;
		}
		return true;
	}
	
	default public String errorMessage() {
		return "Expression Cannot be Evaluated !";
	}
}
