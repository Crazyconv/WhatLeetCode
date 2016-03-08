import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
public class BinaryTreePostorderTraversal{
    public static void main(Strin[] argvs){
        BinaryTreePostorderTraversal btpt = new BinaryTreePostorderTraversal();
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;

        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root)
        TreeNode lastPop = null;
        TreeNode temp = null;
        // push root to stack
        // if has no children, pop, add to result
        // else if the pop is my children, pop
        // else check children
        while(!s.isEmpty()){
            temp = s.peek();
            if(temp.left == null || temp.right == null){
                lastPop = s.pop();
                result.add(lastPop.val);
            } else {
                if(temp.left == lastPop || temp.right == lastPop){
                    lastPop = s.pop();
                    result.add(lastPop.val);
                } else {
                    if(temp.right != null)
                        s.push(temp.right);
                    if(temp.left != null)
                        s.push(temp.left);
                }
            }
        }
        return result;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}