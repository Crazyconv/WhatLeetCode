public class BasicCalculator{
    public int calculate(String s) {
        boolean add = true;
        int sum = 0;
        int num = 0;
        Stack<Integer> si = new Stack<Integer>();
        Stack<Boolean> so = new Stack<Boolean>();
        for(int i = 0; i < s.length(); i++){
        	char c = s.charAt(i);
        	if(c >= '0' && c <= '9'){
        		num = num * 10 + (int)(c - '0');
        	} else {
        		if(add)
        			sum += num;
        		else
        			sum -= num;
        		num = 0;
        		switch(c){
        			case '+': add = true; break;
        			case '-': add = false; break;
        			case '(': si.push(sum); 
        					  so.push(add); 
        					  add = true; 
        					  sum = 0; 
        					  break;
        			case ')': num = sum; 
                              add = so.pop(); 
                              sum = si.pop();
                              if(add) sum += num;
                              else sum -= num;
                              num = 0;
        		}
        	}
        }
        return sum;
    }	
}