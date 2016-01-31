public class BinaryTreeLongestConsecutiveSequence{
    int maxLength = 0;
    public int longestConsecutive(TreeNode root) {
        if(root != null){
            longestConsecutive(root.left, root.val, 1);
            longestConsecutive(root.right, root.val, 1);
        }
        return maxLength;
    }
    public void longestConsecutive(TreeNode root, int lastNum, int length){
        if(root == null){
            maxLength = Math.max(maxLength, length);
            return;
        }
        if(root.val != lastNum + 1){
            maxLength = Math.max(maxLength, length);
            length = 0;
        }
        longestConsecutive(root.left, root.val, length + 1);
        longestConsecutive(root.right, root.val, length + 1);
    }
}