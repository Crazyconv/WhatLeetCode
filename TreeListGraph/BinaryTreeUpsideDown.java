public class BinaryTreeUpsideDown{
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode next = null;
        TreeNode lastRight = null;
        while(cur != null){
            next = cur.left;
            cur.left = lastRight;
            lastRight = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }    
}