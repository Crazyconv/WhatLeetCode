import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
public class UniqueBinarySearchTreesII{
    public List<TreeNode> generateTrees(int n) {
        if(n <= 0)
            return (new ArrayList<TreeNode>());
        HashMap<Pair, ArrayList<TreeNode>> result = new HashMap();
        return generateTrees(1, n, result);
    }
    public ArrayList<TreeNode> generateTrees(int start, int end, HashMap<Pair, ArrayList<TreeNode>> m){
        ArrayList<TreeNode> result;
        if(start > end){
            result = new ArrayList<TreeNode>();
            result.add(null);
        } else{
            Pair key = new Pair(start, end);
            result = m.get(key);
            if(result == null){
                result = new ArrayList<TreeNode>();
                for(int i = start; i <= end; i++){
                    ArrayList<TreeNode> leftList = generateTrees(start, i-1, m);
                    ArrayList<TreeNode> rightList = generateTrees(i+1, end, m);
                    for(TreeNode left: leftList){
                        for(TreeNode right: rightList){
                            TreeNode root = new TreeNode(i);
                            root.left = left;
                            root.right = right;
                            result.add(root);
                        }
                    }
                }
                m.put(key, result);
            }
        }
        return result;
    }
    public static void main(String[] argvs){
        UniqueBinarySearchTreesII ubs = new UniqueBinarySearchTreesII();
        ubs.generateTrees(1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Pair{
    int start;
    int end;
    public Pair(int s, int e){
        start = s;
        end = e;
    }
    public int hashCode(){
        return (String.valueOf(start) + "_" + String.valueOf(end)).hashCode();
    }
    public boolean equals(Object o){
        Pair p = (Pair) o;
        return start == p.start && end == p.end;
    }
}