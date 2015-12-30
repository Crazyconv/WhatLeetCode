public class BinaryTreefromPreIn{
    public TreeNode buildTree(int[] preorder, int[] inorder){
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode buildTree(int[] preorder, int startP, int endP, int[] inorder, int startI, int endI){
        if(endP - startP < 0)
            return null;
        TreeNode t = new TreeNode(preorder[startP]);
        int mid = search(inorder, startI, endI, preorder[startP]);
        t.left = buildTree(preorder, startP + 1, mid - startI + startP, inorder, startI, mid - 1);
        t.right = buildTree(preorder, endP - endI + mid + 1, endP, inorder, mid + 1, endI);
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