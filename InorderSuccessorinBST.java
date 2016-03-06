public class InorderSuccessorinBST{
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null)
            return null;
        if(root.val > p.val){
            TreeNode left = inorderSuccessor(root.left, p);
            return (left == null)? root : left;
        } else
            return inorderSuccessor(root.right, p);
    }    
}