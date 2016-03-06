public class LargestBSTSubtree{
    class Result{
        int size;
        int smallest;
        int largest;
        Result(int size, int smallest, int largest){
            this.size = size;
            this.smallest = smallest;
            this.largest = largest;
        }
    }

    int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        traversal(root);
        return max;
    }    
    public Result traversal(TreeNode root){
        if(root == null)
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Result left = traversal(root.left);
        Result right = traversal(root.right);
        if(left.size == -1 || right.size == -1 || root.val <= left.largest || root.val >= right.smallest)
            return new Result(-1, 0, 0);
        int size = left.size + right.size + 1;
        max = Math.max(max, size);
        return new Result(size, Math.min(left.smallest, root.val), Math.max(right.largest, root.val));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}