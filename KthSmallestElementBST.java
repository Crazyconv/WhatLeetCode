public class KthSmallestElementBST{
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode nextInsert = root;
        int cur = 1;
        while(!s.isEmpty() || nextInsert != null){
            if(nextInsert != null){
                s.push(nextInsert);
                nextInsert = nextInsert.left;
            } else {
                nextInsert = s.pop();
                if(cur == k){
                    return nextInsert.val;
                }
                cur++;
                nextInsert = nextInsert.right;
            }
        }
        return 0;
    }    
}