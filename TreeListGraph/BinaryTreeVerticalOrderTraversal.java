import java.util.*;
public class BinaryTreeVerticalOrderTraversal{
    public List<List<Integer>> verticalOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root != null){
            HashMap<Integer, ArrayList<Integer>> m = new HashMap<Integer, ArrayList<Integer>>();
            LinkedList<TreeNode> tq = new LinkedList<TreeNode>();
            LinkedList<Integer> mq = new LinkedList<Integer>();
            tq.offer(root);
            mp.offer(0);
            while(!tq.isEmpty()){
                TreeNode node = tq.remove();
                int mark = mq.remove();
                ArrayList<Integer> arr = m.get(mark);
                if(arr == null){
                    arr = new ArrayList<Integer>();
                    arr.add(node.val);
                    m.put(mark, arr);
                } else {
                    arr.add(node.val);
                }
                if(node.left != null){
                    tq.offer(node.left);
                    mq.offer(mark - 1);
                }
                if(node.right != null){
                    tq.offer(node.right);
                    mq.offer(mark + 1);
                }
            }

            int min = 0, max = 0;
            for(int key: m.keySet()){
                min = Math.min(min, key);
                max = Math.max(max, key);
            }
            
            for(int i = min; i <= max; i++){
                result.add(m.get(i));
            }
        }
        return result;
    }

    public static void main(String[] argvs){
        BinaryTreeVerticalOrderTraversal btot = new BinaryTreeVerticalOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        btot.verticalOrder(root);
    } 
}

class TreeNode{
    int val;
    TreeNode left, right;
    public TreeNode(int val){
        this.val = val;
    }
}

class Pair{
    TreeNode node;
    int mark;
    public Pair(TreeNode node, int mark){
        this.node = node;
        this.mark = mark;
    }
}