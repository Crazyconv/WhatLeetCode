import java.util.Stack;
public class BSTFromPreorder{
    public TreeNode fromPreorder(int[] preorder){
        if(preorder == null || preorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        for(int i = 1; i < preorder.length; i++){
            TreeNode node = new TreeNode(preorder[i]);
            if(s.peek().val > preorder[i]){
                s.peek().left = node;
            } else {
                TreeNode last = null;
                while(!s.isEmpty() && s.peek().val < preorder[i]){
                    last = s.pop();
                }
                last.right = node;
            }
            s.push(node);
        }
        return root;
    }
    public void printInorder(TreeNode root){
        if(root != null){
            printInorder(root.left);
            System.out.printf("%d ", root.val);
            printInorder(root.right);
        }
    }
    public static void main(String[] argvs){
        BSTFromPreorder bfp = new BSTFromPreorder();
        int[] preorder = {5, 3, 1, 2, 4, 8, 7, 6, 10, 9, 11};
        bfp.printInorder(bfp.fromPreorder(preorder));
        System.out.println();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}