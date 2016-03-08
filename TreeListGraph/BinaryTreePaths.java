public class BinaryTreePaths{
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> result = new ArrayList<String>();
        if(root != null){
            StringBuilder sb = new StringBuilder();
            traversal(root, sb, result);
        }
        return result;
    }    
    public void traversal(TreeNode root, StringBuilder sb, ArrayList<String> result){
        int length = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null){
            result.add(sb.toString());
        } else {
            sb.append("->");
            if(root.left != null){
                traversal(root.left, sb, result);
            }
            if(root.right != null){
                traversal(root.right, sb, result);
            }
        }
        sb.setLength(length);
    }
}

class TreeNode{
    int val;
    TreeNode left; 
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}