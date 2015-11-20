/* 
 * http://www.geeksforgeeks.org/suffix-tree-application-6-longest-palindromic-substring/
 * get longest common substring of the string and its reversed string, which starts in the same index of S
 * indexR + indexS = s.length - 1 - (maxLength - 1)
 * indexS/R is the startIndex of the LCS in s/r;
 */

import java.util.HashSet;
public class LongestPalindromicSubstring{
    int maxLength;
    int maxStartIndex;

    public IndexSet traversal(GeneralizedSuffixTree.Node node, int sLen, int level){
        if(node == null)
            return null;
        if(node.suffixIndex == -1){ // internal node
            IndexSet res = new IndexSet();
            for(int i = 0; i < 256; i++){
                if(node.children[i] != null){
                    IndexSet subRes = traversal(node.children[i], sLen, level + node.children[i].getLength());
                    res.forwardIndices.addAll(subRes.forwardIndices);
                    res.reverseIndices.addAll(subRes.reverseIndices);
                }
            }
            for(Integer index: res.forwardIndices){
                int target = sLen - 2 - (level - 1) - index;
                if(res.reverseIndices.contains(target)){
                    if(level > maxLength || (level == maxLength && node.end.value - level + 1 < maxStartIndex)){
                        maxLength = level;
                        maxStartIndex = node.end.value - level + 1;
                    }
                }
            }
            return res;
        } else { // leaf node
            IndexSet res = new IndexSet();
            if(node.suffixIndex >= sLen)
                res.reverseIndices.add(node.suffixIndex - sLen);
            else
                res.forwardIndices.add(node.suffixIndex);
            return res;
        }
    }

    public void getLPS(String s){
        maxLength = 0;
        maxStartIndex = 0;
        String reverseS = new StringBuilder(s).reverse().toString();
        GeneralizedSuffixTree gst = new GeneralizedSuffixTree(s+"#"+reverseS+'$');
        traversal(gst.root, s.length()+1, 0);
        if(maxLength > 0)
            System.out.printf("LPS[%d]: %s\n", maxLength, s.substring(maxStartIndex, maxStartIndex + maxLength));
        else
            System.out.println("No LPS.");
    }

    public static void main(String[] argvs){
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        lps.getLPS("cabbaabb");
        lps.getLPS("forgeeksskeegfor");
        lps.getLPS("abcde");
        lps.getLPS("abcdae");
        lps.getLPS("abacd");
        lps.getLPS("abcdc");
        lps.getLPS("abacdfgdcaba");
        lps.getLPS("xyabacdfgdcaba");
        lps.getLPS("xababayz");
        lps.getLPS("xabax");    
    }
}
class IndexSet{
    HashSet<Integer> forwardIndices;
    HashSet<Integer> reverseIndices;
    public IndexSet(){
        forwardIndices = new HashSet<Integer>();
        reverseIndices = new HashSet<Integer>();
    }
}