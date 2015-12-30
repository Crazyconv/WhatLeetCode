public class LowestCommonAncestorBT{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root, p, q).node;
    }
    public CountTree LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return new CountTree(null, 0);

        int count = (root == p || root == q)? 1:0;

        CountTree leftTree = LCA(root.left, p, q);
        int leftCount = leftTree.count;
        if(leftCount == 2)
            return leftTree;
        CountTree rightTree = LCA(root.right, p, q);
        int rightCount = rightTree.count;
        if(rightCount == 2)
            return rightTree;

        return new CountTree(root, leftCount + rightCount + count);
    }  
}

class CountTree{
    TreeNode node;
    int count;
    public CountTree(TreeNode node, int count){
        this.node = node;
        this.count = count;
    }
}