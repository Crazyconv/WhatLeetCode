import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
public class BinaryTreePreorderTraversal{
    public static void main(Strin[] argvs){
        BinaryTreePreorderTraversal btpt = new BinaryTreePreorderTraversal();
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode temp = null;
        s.push(root);
        while(!s.isEmpty()){
            temp = s.pop();
            result.add(temp.val);
            if(temp.right != null)
                s.push(temp.right);
            if(temp.left != null)
                s.push(temp.left);
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