public class SearchPattern{
    SuffixTree st;
    public SearchPattern(String s){
        st = new SuffixTree(s);
    }
    public int leafCount(SuffixTree.Node node){
        if(node.suffixIndex > -1){ //leaf
            System.out.println("Found at position: " + String.valueOf(node.suffixIndex));
            return 1;
        }
        int count = 0;
        for(int i = 0; i < 256; i++){
            if(node.children[i] != null){
                count += leafCount(node.children[i]);
            }
        }
        return count;
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
            if(res == -1)
                return res;
            else if (res == 1){
                System.out.println("substring count: " + String.valueOf(leafCount(node)));
                return res;
            }
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
            System.out.println("Pattern <" + p + "> is a Substring\n");
        else
            System.out.println("Pattern <" + p + "> is NOT a Substring\n");
    }
    public static void main(String[] argvs){
        SearchPattern sp = new SearchPattern("GEEKSFORGEEKS$");
        sp.checkForSubString("GEEKS");
        sp.checkForSubString("GEEK1");
        sp.checkForSubString("FOR");
        sp = new SearchPattern("AABAACAADAABAAABAA$");
        sp.checkForSubString("AABA");
        sp.checkForSubString("AA");
        sp.checkForSubString("AAE");
        sp = new SearchPattern("AAAAAAAAA$");
        sp.checkForSubString("AAAA");
        sp.checkForSubString("AA");
        sp.checkForSubString("A");
        sp.checkForSubString("AB");
    }
}