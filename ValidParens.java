import java.util.Stack;
public class ValidParens{
    public boolean isValid(String s){
        if(s == null || s.length()%2 == 1){
            return false;
        }
        Stack<Character> st = new Stack<Character>();
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
                st.push(c);
            else if(st.isEmpty() || (st.peek() == '[' && c != ']') ||
                (st.peek() == '{' && c != '}') || (st.peek() == '(' && c != ')'))
                return false;
            else
                st.pop();
            i++;
        }
        return st.isEmpty();
    }
    public static void main(String[] argvs){
        ValidParens vp = new ValidParens();
        System.out.println(vp.isValid("()"));
        System.out.println(vp.isValid("()[]{}"));
        System.out.println(vp.isValid("(]"));
        System.out.println(vp.isValid("([)]"));
    }
}