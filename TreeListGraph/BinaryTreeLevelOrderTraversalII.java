public class BinaryTreeLevelOrderTraversalII{
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if(root == null)
            return result;

        ArrayList<Integer> level = new ArrayList<Integer>();
        LinkedList<TreeNode> cur = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        cur.offer(root);
        TreeNode temp = null;
        while(!cur.isEmpty()){
            temp = cur.poll();
            level.add(temp.val);
            if(temp.left != null)
                next.offer(temp.left);
            if(temp.right != null)
                next.offer(temp.right);
            if(cur.isEmpty()){
                result.offerFirst(level);
                level = new ArrayList<Integer>();
                cur = next;
                next = new LinkedList<TreeNode>();
            }
        }
        return result;
    }  
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}