public class LowestCommonAncestorBST{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode smaller, larger;
        if(p.val <= q.val){
            smaller = p;
            larger = q;
        } else {
            smaller = q;
            larger = p;
        }
        if(smaller.val <= root.val && larger.val >= root.val)
            return root;
        else if(smaller.val > root.val)
            return lowestCommonAncestor(root.right, smaller, larger);
        else
            return lowestCommonAncestor(root.left, smaller, larger);
    }    
}