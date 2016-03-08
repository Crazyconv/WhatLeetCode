public class CountCompleteTreeNodes{
    // too tedious
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

    // a complete binary tree's height is its left subtree's height + 1
    public int getHeight(TreeNode root){
        int height = -1;
        while(root != null){
            root = root.left;
            height ++;
        }
        return height;
    }
    public int countNodes(TreeNode root) {
        int nodes = 0;
        int h = getHeight(root);
        TreeNode cur = root;
        while(cur != null){
            int rightHeight = getHeight(cur.right);
            if(rightHeight + 1 == h){
                nodes += 1 << h;
                cur = cur.right;
            } else {
                nodes += 1 << (h - 1);
                cur = cur.left;
            }
            h --;
        }
        return nodes;
    }   

    // check most left and most right
    public int countNodes(TreeNode root) {
        int nodes = 0;
        if(root != null){
            TreeNode left = root, right = root;
            int height = 0;
            while(right != null){
                height ++;
                left = left.left;
                right = right.right;
            }
            if(left == null)
                return (1 << height) - 1;
            else
                return 1 + countNodes(root.left) + countNodes(root.right);
        }
        return nodes;
    }

}