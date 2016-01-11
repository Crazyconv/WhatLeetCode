public class GenerateParentheses{
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if(n > 0){
            generate(n, 0, 0, new char[n*2], result);
        }
        return result;
    }    
    public void generate(int left, int net, int pos, char[] item, ArrayList<String> result){
        if(pos == item.length)
            result.add(new String(item));
        else {
            if(left > 0){
                item[pos] = '(';
                generate(left - 1, net + 1, pos + 1, item, result);
            }
            if(net > 0){
                item[pos] = ')';
                generate(left, net - 1, pos + 1, item, result);
            }
        }
    }
}