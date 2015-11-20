/*
 * http://www.geeksforgeeks.org/suffix-tree-application-5-longest-common-substring-2/
 */ 
public class LongestCommonSubstring{
    int maxLength = 0;
    int maxStartIndex = 0;
    public int traversal(GeneralizedSuffixTree.Node node, int sLen, int level){
        if(node == null)
            return 0;
        if(node.suffixIndex == -1){ // internal node
            int mark = 0;
            for(int i = 0; i < 256; i++){
                if(node.children[i] != null){
                    int res = traversal(node.children[i], sLen, level+node.children[i].getLength());
                    if(mark == 0){
                        mark = res; // 1:X, 2:Y, 3:XY
                    }
                    if(res == 3 || (mark == 1 && res == 2) || (mark == 2 && res == 1)){
                        if(node.start != -1){ // non root
                            if(level > maxLength || (level == maxLength && node.end.value - level + 1 < maxStartIndex)){
                                maxLength = level;
                                maxStartIndex = node.end.value - level + 1;
                            }
                        }
                        mark = 3;
                    }
                }
            }
            return mark;
        } else { // leaf node
            if(node.suffixIndex >= sLen)
                return 2;
            else
                return 1;
        }
    }
    public void getLCS(String s, String p){
        maxLength = 0;
        maxStartIndex = 0;
        GeneralizedSuffixTree gst = new GeneralizedSuffixTree(s+"#"+p+"$");
        traversal(gst.root, s.length()+1, 0);
        if(maxLength > 0)
            System.out.printf("LCS[%d]: %s\n", maxLength, s.substring(maxStartIndex, maxStartIndex + maxLength));
        else
            System.out.println("No LCS.");
    }
    public static void main(String[] argvs){
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        lcs.getLCS("xabxac", "abcabxabcd");
        lcs.getLCS("xabxaabxa","babxba");
        lcs.getLCS("GeeksforGeeks","GeeksQuiz");
        lcs.getLCS("OldSite:GeeksforGeeks.org", "NewSite:GeeksQuiz.com");
        lcs.getLCS("abcde","fghie");
        lcs.getLCS("pqrst","uvwxyz");
    }
}