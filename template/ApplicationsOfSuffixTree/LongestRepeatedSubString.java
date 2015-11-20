/*
 * http://www.geeksforgeeks.org/suffix-tree-application-3-longest-repeated-substring/
 */
public class LongestRepeatedSubString{
    int maxLength = 0;
    int maxStartIndex = 0;
    public void traversal(SuffixTree.Node node, int level){
        if(node == null)
            return;
        if(node.suffixIndex == -1){
            for(int i = 0; i < 256; i++){
                if(node.children[i] != null){
                    traversal(node.children[i], level+node.getLength());
                }
            }
        } else { // leaf node
            if(level > maxLength || (level == maxLength && level > 0 && node.suffixIndex < maxStartIndex)){
                maxLength = level;
                maxStartIndex = node.suffixIndex;
            }
        }
    }
    public void getLRSIndex(String s){
        maxLength = 0;
        maxStartIndex = 0;

        SuffixTree st = new SuffixTree(s);
        traversal(st.root, 0);
        if(maxLength > 0){
            System.out.println(s.substring(maxStartIndex, maxStartIndex + maxLength) + "\n");
        } else {
            System.out.println("No repeated substring\n");
        }
    }
    public static void main(String[] argvs){
        LongestRepeatedSubString lrs = new LongestRepeatedSubString();
        lrs.getLRSIndex("GEEKSFORGEEKS$");
        lrs.getLRSIndex("AAAAAAAAAA$"); 
        lrs.getLRSIndex("ABCDEFG$"); 
        lrs.getLRSIndex("ABABABA$"); 
        lrs.getLRSIndex("ATCGATCGA$");  
        lrs.getLRSIndex("banana$"); 
        lrs.getLRSIndex("abcpqrabpqpq$");  
        lrs.getLRSIndex("pqrpqpqabab$"); 
    }
}