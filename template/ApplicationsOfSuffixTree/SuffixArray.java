/*
 * http://www.geeksforgeeks.org/suffix-tree-application-4-build-linear-time-suffix-array/
 */
import java.util.Arrays;
import java.util.Comparator;
public class SuffixArray{
    int[] indexArray;
    int cur;

    public void traversal(SuffixTree.Node node){
        if(node == null)
            return;
        if(node.suffixIndex != -1){ // leaf
            if(node.suffixIndex != indexArray.length){
                indexArray[cur] = node.suffixIndex;
                cur ++;
            }
        } else {
            for(int i = 0; i < 256; i ++){
                if(node.children[i] != null){
                    traversal(node.children[i]);
                }
            }
        }
    }
    public void buildSuffixArray(String s){
        SuffixTree ts = new SuffixTree(s+"$");
        indexArray = new int[s.length()];
        cur = 0;
        traversal(ts.root);
    }

    public static void main(String[] argvs){
        SuffixArray sa = new SuffixArray();
        sa.buildSuffixArray("banana");
        for(int i = 0; i < sa.indexArray.length; i++){
            System.out.print(String.valueOf(sa.indexArray[i]) + " ");
        }
    }
}
class Suffix{
    int index;
    String s;
    public Suffix(int index, String s){
        this.index = index;
        this.s = s;
    }
}