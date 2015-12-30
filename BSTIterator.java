import java.util.Stack;
public class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack<TreeNode>();
        while(root != null){
            s.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode next = s.pop();
        int result = next.val;
        next = next.right;
        while(next != null){
            s.push(next);
            next = next.left;
        }
        return result;
    }
    public static void main(String[] argvs){
        TreeNode root = new TreeNode(1);
        BSTIterator bi = new BSTIterator(root);
        while(bi.hasNext())
            System.out.println(bi.next());
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}