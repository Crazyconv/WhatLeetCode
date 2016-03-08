public class BalancedBinaryTree{
    public boolean isBalanced(TreeNode root) {
        return (getHeight(root) != -1);
    }
    public int getHeight(TreeNode node){
        if(node == null)
            return 0;
        int leftHeight, rightHeight;
        if((leftHeight = getHeight(node.left)) != -1 
            && (rightHeight = getHeight(node.right)) != -1
            && leftHeight - rightHeight >= -1 && leftHeight - rightHeight <= 1){
            return (leftHeight > rightHeight)? leftHeight + 1 : rightHeight + 1;
        } else {
            return -1;
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}