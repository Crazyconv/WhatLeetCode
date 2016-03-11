public class RemoveInvalidParentheses{
    // BFS: avoid duplicates rather than using set
    // possible duplicates:
    // 1. consequtive '(' and ')', remove any of than is the same
    // 2. remove two positions but in different order is the same
    // 3. remove '(' than ')' is not necessary
    // problems:
    // 1. repetitive valid checking
    // 2. do not have a remove strategy
    // 15 ms
    public List<String> removeInvalidParentheses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        if(isValid(s))
            result.add(s);
        else{
            ArrayList<Tuple> cur = new ArrayList<Tuple>();
            cur.add(new Tuple(new StringBuilder(s), 0, ')'));
            while(!cur.isEmpty()){
                ArrayList<Tuple> next = new ArrayList<Tuple>();
                for(Tuple t : cur){
                    String temp = t.ss;
                    for(int i = t.nextRemoveIndex; i < temp.length(); i++){
                        char c = temp.charAt(i);
                        if(c != ')' && c != '(') continue;
                        if(i != t.nextRemoveIndex && c == temp.charAt(i-1)) continue;
                        if(c == ')' && t.lastRemove == '(') continue;
                        String st = temp.substring(0, i) + temp.substring(i + 1);
                        if(isValid(st))
                            result.add(st);
                        else if(result.isEmpty())
                            next.add(new Tuple(st, i, c));
                    }
                }
                if(!result.isEmpty()) break;
                cur = next;
            }
        }
        return result;
    }

    public boolean isValid(String s){
        int net = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                net ++;
            else if(s.charAt(i) == ')'){
                if(net -- == 0)
                    return false;
            }
        }
        return net == 0;
    }


    // DFS: always do the right step, always make sure the prefix is valid
    // do from left to right, than reverse (so that dp can be applied)
    // duplicates: consequtive '(' and ')', remove in different order
    // similar to the BFS, but can avoid repetitive valid checking
    // 3 ms
    public List<String> removeInvalidParentheses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        char[] chs = {'(', ')'};
        removeInvalidParentheses(s, 0, 0, result, chs);
        return result;
    }

    public void removeInvalidParentheses(String s, int pos, int remove, ArrayList<String> result, char[] chs){
        int count = 0;
        for(int i = pos; i < s.length(); i++){
            if(s.charAt(i) == chs[0]) count ++;
            else if(s.charAt(i) == chs[1]) count --;
            if(count < 0){
                for(int j = remove; j <= i; j++){
                    if(s.charAt(j) == chs[1] && (j == remove || s.charAt(j) != s.charAt(j - 1)))
                        removeInvalidParentheses(s.substring(0, j) + s.substring(j + 1), i, j, result, chs);                }
                return;
            }
        }

        s = new StringBuilder(s).reverse().toString();
        if(chs[0] == ')')
            result.add(s);
        else{
            char[] chsx = {')', '('};
            removeInvalidParentheses(s, 0, 0, result, chsx);
        }
    }


    // DFS: preprocess to know the number of '(' and ')' to remove
    // dynamic valid checking 
    // like bit operation: remove from smaller index
    // duplicates: consequtive '(' and ')'
    // 3 ms
    public List<String> removeInvalidParentheses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        int rmL = 0, rmR = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                rmL ++;
            else if(s.charAt(i) == ')'){
                if(rmL > 0)
                    rmL --;
                else
                    rmR ++;
            }
        }
        remove(s, 0, rmL, rmR, 0, result, new StringBuilder(), -1);
        return result;
    } 
    public void remove(String s, int pos, int rmL, int rmR, int open, ArrayList<String> result, StringBuilder sb, int lastRemove){
        if(pos == s.length() && rmL == 0 && rmR == 0 && open == 0){
            result.add(sb.toString());
            return;
        }
        else if(pos == s.length() || rmL < 0 || rmR < 0 || open < 0)
            return;

        char c = s.charAt(pos);
        int len = sb.length();
        if(c == '('){
            if(pos == 0 || s.charAt(pos - 1) != c || lastRemove == pos - 1)
                remove(s, pos + 1, rmL - 1, rmR, open, result, sb, pos);
            remove(s, pos + 1, rmL, rmR, open + 1, result, sb.append(c), lastRemove);
        } else if(c == ')'){
            if((pos == 0 || s.charAt(pos - 1) != c || lastRemove == pos - 1) && (lastRemove < 0 || s.charAt(lastRemove) != '('))
                remove(s, pos + 1, rmL, rmR - 1, open, result, sb, pos);
            remove(s, pos + 1, rmL, rmR, open - 1, result, sb.append(c), lastRemove);
        } else {
            remove(s, pos + 1, rmL, rmR, open, result, sb.append(c), lastRemove);
        }
        sb.setLength(len);
    }
}

class Tuple{
    StringBuilder ss;
    int nextRemoveIndex;
    char lastRemove;
    public Tuple(String ss, int nextRemoveIndex, char lastRemove){
        this.ss = ss;
        this.nextRemoveIndex = nextRemoveIndex;
        this.lastRemove = lastRemove;
    }
}