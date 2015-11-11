public class BinaryTreefromInPost{
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, inorder.length - 1);
    }
    public TreeNode buildTree(int[] inorder, int si, int ei, int[] postorder, int sp, int ep){
        if(ei - si < 0)
            return null;
        TreeNode t = new TreeNode(postorder[ep]);
        int mid = search(inorder, si, ei, postorder[ep]);
        t.left = buildTree(inorder, si, mid-1, postorder, sp, mid-1-si+sp);
        t.right = buildTree(inorder, mid+1, ei, postorder, mid-si+sp, ep-1);
        return t;
    }
    public int search(int[] inorder, int start, int end, int target){
        for(int i = start; i <= end; i++){
            if(inorder[i] == target)
                return i;
        }
        return 0;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}