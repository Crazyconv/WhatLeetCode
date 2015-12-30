public class BinaryTreeRightSideView{
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root != null){
            ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
            ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
            pre.add(root);
            while(!pre.isEmpty()){
                result.add(pre.get(pre.size()-1).val);
                for(TreeNode node : pre){
                    if(node.left != null)
                        cur.add(node.left);
                    if(node.right != null)
                        cur.add(node.right);
                }
                pre = cur;
                cur = new ArrayList<TreeNode>();
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