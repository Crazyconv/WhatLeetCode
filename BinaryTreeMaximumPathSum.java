public class BinaryTreeMaximumPathSum{
    int max = 0;
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        max = Integer.MIN_VALUE;
        maxSum(root);
        return max;
    }
    public int maxSum(TreeNode node){
        int maxRoot; // node as root
        int maxPass; // pass node
        if(node.left == null && node.right == null){
            maxRoot = maxPass = node.val;
        } else {
            int leftSum = (node.left != null)? maxSum(node.left):Integer.MIN_VALUE;
            int rightSum = (node.right != null)? maxSum(node.right):Integer.MIN_VALUE;
            maxPass = node.val;
            if(leftSum > 0)
                maxPass += leftSum;
            if(rightSum > 0)
                maxPass += rightSum;
            maxRoot = (leftSum > rightSum)? leftSum : rightSum;
            maxRoot = (maxRoot > 0)? maxRoot+node.val : node.val;
        }
        max = (max < maxPass)? maxPass : max;
        return maxRoot;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}