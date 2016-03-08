public class RecoverBinarySearchTree{
    TreeNode first, second;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    // recursive in order, but in O(n) space
    public void recoverTree(TreeNode root){
        checkTree(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void checkTree(TreeNode root) {
        if(root != null){
            checkTree(root.left);
            if(pre.val > root.val){
                if(first == null)
                    first = pre;
                second = root;
            }
            pre = root;
            checkTree(root.right);
        }
    }    

    // morris traversal

    TreeNode first, second;
    TreeNode last = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root){
        checkTree(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void checkTree(TreeNode root) {
        TreeNode cur = root, pre = null;
        while(cur != null){
            if(cur.left == null){
                check(cur);
                cur = cur.right;
            } else {
                pre = cur.left;
                while(pre.right != null && pre.right != cur)
                    pre = pre.right;
                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    check(cur);
                    cur = cur.right;
                }
            }
        }
    }
    public void check(TreeNode cur){
        if(cur.val < last.val){
            if(first == null)
                first = last;
            second = cur;
        }
        last = cur;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}