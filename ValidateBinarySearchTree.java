public class ValidateBinarySearchTree {
    // public boolean isValidBST(TreeNode root) {
    //     if(root == null || isValid(root) != null)
    //         return true;
    //     else
    //         return false;
    // }
    // public int[] isValid(TreeNode root){
    //     int[] range = new int[2];
        
    //     int[] leftRange, rightRange;
    //     if(root.left != null){
    //         leftRange = isValid(root.left);
    //         if(leftRange == null || leftRange[1] >= root.val)
    //             return null;
    //         range[0] = leftRange[0];
    //     } else {
    //         range[0] = root.val;
    //     }
    //     if(root.right != null){
    //         rightRange = isValid(root.right);
    //         if(rightRange == null || rightRange[0] <= root.val)
    //             return null;
    //         range[1] = rightRange[1];
    //     }else{
    //         range[1] = root.val;
    //     }
    //     return range;
    // }
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
 
        LinkedList<BNode> queue = new LinkedList<BNode>();
        queue.add(new BNode(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
        while(!queue.isEmpty()){
            BNode b = queue.poll();
            if(b.n.val <= b.left || b.n.val >=b.right){
                return false;
            }
            if(b.n.left!=null){
                queue.offer(new BNode(b.n.left, b.left, b.n.val));
            }
            if(b.n.right!=null){
                queue.offer(new BNode(b.n.right, b.n.val, b.right));
            }
        }
        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class BNode{
    TreeNode n;
    double left;
    double right;
    public BNode(TreeNode n, double left, double right){
        this.n = n;
        this.left = left;
        this.right = right;
    }
}