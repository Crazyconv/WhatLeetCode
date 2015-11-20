public class SearchPattern{
    SuffixTree st;
    public SearchPattern(String s){
        st = new SuffixTree(s);
    }
    public int checkEdge(SuffixTree.Node node, String s, int pos){
        int start = node.start;
        while(start <= node.end.value && pos < s.length()){
            if(s.charAt(pos) == st.s.charAt(start)){
                start ++;
                pos ++;
            } else {
                return -1; // does not match, finish checking
            }
        }
        if(pos == s.length())
            return 1; // match, finish checking
        return 0; // partial match, continue checking
    }
    public int traversal(SuffixTree.Node node, String s, int pos){
        if(node == null)
            return -1;
        if(node.start != -1){
            int res = checkEdge(node, s, pos);
            if(res != 0)
                return res;
        }
        pos += node.getLength();
        SuffixTree.Node next = node.children[s.charAt(pos)];
        if(next == null)
            return -1;
        else
            return traversal(next, s, pos);
    }
    public void checkForSubString(String p){
        int result = traversal(st.root, p, 0);
        if(result == 1)
            System.out.println("Pattern <" + p + "> is a Substring");
        else
            System.out.println("Pattern <" + p + "> is NOT a Substring");
    }
    public static void main(String[] argvs){
        SearchPattern sp = new SearchPattern("THIS IS A TEST TEXT$");
        sp.checkForSubString("TEST");
        sp.checkForSubString("A");
        sp.checkForSubString(" ");
        sp.checkForSubString("IS A");
        sp.checkForSubString(" IS A ");
        sp.checkForSubString("TEST1");
        sp.checkForSubString("THIS IS GOOD");
        sp.checkForSubString("TES");
        sp.checkForSubString("TESA");
        sp.checkForSubString("ISB");
    }
}