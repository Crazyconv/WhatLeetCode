public class PathSum{
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;

        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<Integer> v = new Stack<Integer>();
        s.push(root);
        v.push(sum);

        TreeNode cur = null;
        int cur_v = 0;
        while(!s.isEmpty()){
            cur = s.pop();
            cur_v = v.pop();
            if(isLeaf(cur)){
                if(cur.val == cur_v)
                    return true;
            } else {
                if(cur.right != null){
                    s.push(cur.right);
                    v.push(cur_v - cur.val);
                }
                if(cur.left != null){
                    s.push(cur.left);
                    v.push(cur_v - cur.val);
                }
            }
        }
        return false;
    } 
    // public boolean hasPathSum(TreeNode root, int sum) {
    //     if (root == null)
    //         return false;
    //     if (root.val == sum && (root.left == null && root.right == null))
    //         return true;
     
    //     return hasPathSum(root.left, sum - root.val)
    //             || hasPathSum(root.right, sum - root.val);
    // }
    public boolean isLeaf(TreeNode node){
        return (node.left == null && node.right == null);
    }    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}