public class SymmetricTree{
    // iterative
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        else{
            boolean result = true;
            Stack<TreeNode> s = new Stack<TreeNode>();
            s.push(root.left);
            s.push(root.right);
            while(!s.isEmpty()){
                TreeNode left = s.pop();
                TreeNode right = s.pop();
                if(left != null && right != null){
                    s.push(left.left);
                    s.push(right.right);
                    s.push(left.right);
                    s.push(right.left);
                } else if(left == null && right == null && left.val == right.val){
                    continue;
                } else {
                    result = false;
                    break;
                }
            }
            return result;
        }
    }

    // recursive
    public boolean isSymmetricRe(TreeNode root) {
        if(root == null)
            return true;
        else
            return isSymmetricRe(root.left, root.right);
    }   
    public boolean isSymmetricRe(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        else if(left != null && right != null)
            return left.val == right.val && isSymmetricRe(left.left, right.right) 
        && isSymmetricRe(left.right, right.left);
        else
            return false;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}