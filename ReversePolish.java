import java.util.Stack;

public class ReversePolish{
	public static int naiveStack(String[] tokens){
		Stack<Integer> s = new Stack();
		int a, b;
		for(String token: tokens){
			if(!(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))){
				s.push(Integer.valueOf(token));
			} else {
				b = s.pop();
				a = s.pop();
				switch(token){
					case "+":
						s.push(a + b);
						break;
					case "-":
						s.push(a - b);
						break;
					case "*":
						s.push(a * b);
						break;
					case "/":
						s.push(a / b);
						break;
				}
			}
		}
		return s.pop();
	}
	public static void main(String[] argvs){
		String[] tokens = new String[] {"4", "13", "5", "/", "+"};
		System.out.println(naiveStack(tokens));
		tokens = new String[] {"2", "1", "+", "3", "*"};
		System.out.println(naiveStack(tokens));
	}
}