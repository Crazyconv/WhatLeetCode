public class CountCompleteTreeNodes{
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        TreeNode left = root;
        TreeNode right = root;
        int leftHeight = 0;
        int rightHeight = 0;
        while(left != null){
            leftHeight ++;
            left = left.left;
        }
        while(right != null){
            rightHeight ++;
            right = right.right;
        }
        if(leftHeight == rightHeight)
            return (2 << (leftHeight - 1)) - 1;
        else
            return 1 + countRight(root.left, leftHeight-1) + countLeft(root.right, rightHeight-1);
    }    
    public int countRight(TreeNode root, int leftHeight){
        if(root == null)
            return 0;
        else{
            TreeNode temp = root;
            int rightHeight = 0;
            while(temp != null){
                rightHeight ++;
                temp = temp.right;
            }
            if(leftHeight == rightHeight)
                return (2 << (leftHeight - 1)) - 1;
            else
                return 1 + countRight(root.left, leftHeight-1) + countLeft(root.right, rightHeight-1);
        }
    }
    public int countLeft(TreeNode root, int rightHeight){
        if(root == null)
            return 0;
        else{
            TreeNode temp = root;
            int leftHeight = 0;
            while(temp != null){
                leftHeight ++;
                temp = temp.left;
            }
            if(leftHeight == rightHeight)
                return (2 << (leftHeight - 1)) - 1;
            else
                return 1 + countRight(root.left, leftHeight-1) + countLeft(root.right, rightHeight-1);
        }
    }
}