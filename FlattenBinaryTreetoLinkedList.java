public class FlattenBinaryTreetoLinkedList{
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        while(true){
            if(cur.left == null && cur.right == null){
                if(!s.isEmpty()){
                    cur.right = s.pop();
                    cur = cur.right;
                } else {
                    break;
                }
            } else if(cur.left == null){
                cur = cur.right;
            } else {
                if(cur.right != null){
                    s.push(cur.right);
                }
                cur.right = cur.left;
                cur.left = null;
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}