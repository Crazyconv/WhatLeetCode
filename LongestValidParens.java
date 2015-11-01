import java.util.Stack;
public class LongestValidParens{
    public int longestValidParentheses(String s){
        int cur = 0;
        int max = 0;
        if(s != null){
            Stack<Character> st = new Stack<Character>();
            int i = 0;
            while(i < s.length()){
                char c = s.charAt(i);
                if(c == '(' || c == '[' || c == '{')
                    st.push(c);
                else if(st.isEmpty() || (st.peek() != '[' && c == ']') ||
                    (st.peek() != '{' && c == '}') || (st.peek() != '(' && c == ')')){
                    max = (max < cur)? cur : max;
                    cur = 0;
                    st.push(c);
                }
                else{
                    st.pop();
                    cur += 2;
                }
                i++;
            }
        }
        max = (max < cur)? cur : max;
        return max;
    }
    public static void main(String[] argvs){
        LongestValidParens vp = new LongestValidParens();
        System.out.println(vp.longestValidParentheses("(()"));
        System.out.println(vp.longestValidParentheses(")()())"));
        System.out.println(vp.longestValidParentheses("(]"));
        System.out.println(vp.longestValidParentheses("(])]"));
    }    
}