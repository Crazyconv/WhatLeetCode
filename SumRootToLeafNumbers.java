public class SumRootToLeafNumbers{
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        return sumNumbers(root, 0);
    }    
    public int sumNumbers(TreeNode root, int prefix){
        prefix = prefix * 10 + root.val;
        if(root.left == null && root.right == null)
            return prefix;
        int sum = 0;
        if(root.left != null)
            sum += sumNumbers(root.left, prefix);
        if(root.right != null)
            sum += sumNumbers(root.right, prefix);
        return sum;        
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}