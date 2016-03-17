import java.util.*;
public class BasicCalculatorII{
    public int calculate(String s) {
        int sum = 0;
        int num = 0;
        char sign = '+';
        Stack<Integer> so = new Stack<Integer>();
        Stack<Integer> si = new Stack<Integer>();
        for(int i = 0; i <= s.length(); i++){
        	// handling of end of string is same to when current is +/-
        	if(i == s.length() || s.charAt(i) == '+' || s.charAt(i) == '-'){
        		switch (sign){
        			case '+': sum += num; break;
        			case '-': sum -= num; break;
        			case '*': 
        			case '/': sum = (sign == '*')? sum * num: sum / num; 
        					  num = sum;
        					  sum = si.pop() + so.pop() * num;
        		}
        		num = 0; 
        		if(i != s.length()) 
        			sign = s.charAt(i);
        	} else if (s.charAt(i) == '*' || s.charAt(i) == '/'){
        		switch (sign){
        			case '+': 
        			case '-': si.push(sum); 
        			          so.push((sign == '+')? 1 : -1); 
        			          sum = num; 
        			          break;
        			case '*': sum *= num; break;
        			case '/': sum /= num; break;
        		}
        		sign = s.charAt(i); 
                num = 0; 
        	} else if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
        		num = num * 10 + (int)(s.charAt(i) - '0');
        	}
        	System.out.printf("%d - %d - %c\n",sum,num,sign);
        }
        System.out.println(sum);
        return sum;
    }	
    public static void main(String[] argvs){
    	BasicCalculatorII bc = new BasicCalculatorII();
    	bc.calculate(" 5 / 2 ");
    }
}