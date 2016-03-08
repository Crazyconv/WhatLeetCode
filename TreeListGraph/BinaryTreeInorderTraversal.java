import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
public class BinaryTreeInorderTraversal{
    public static void main(Strin[] argvs){
        BinaryTreeInorderTraversal btpt = new BinaryTreeInorderTraversal();
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode temp = root;
        while(!s.isEmpty() || temp != null){
            if(temp != null){
                s.push(temp);
                temp = temp.left;
            } else {
                temp = s.pop();
                result.add(temp.val);
                temp = temp.right;
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