public class CountUnivalueSubtrees{

    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root != null)
            traversal(root);
        return count;
    }

    public Integer traversal(TreeNode root){
        if(root.left == null && root.right == null){
            count ++;
            return root.val;
        }

        boolean uni = true;
        if(root.left != null){
            Integer left = traversal(root.left);
            if(left == null || left != root.val)
                uni = false;
        }
        if(root.right != null){
            Integer right = traversal(root.right);
            if(right == null || right != root.val)
                uni = false;
        }
        if(uni){
            count ++;
            return root.val;
        } else
            return null;
    }
}