public class PathSumII{
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> results = new List<List<Integer>>();
        if(root == null)
            return results;

        ArrayList<Integer> oneResult = new ArrayList<Integer>();
        pathSum(root, sum, oneResult, results);
        return results;     
    }
    public void pathSum(TreeNode root, int sum, ArrayList<Integer> oneResult, ArrayList<List<Integer>> results){
        if(isLeaf(root) && (root.val == sum)){
            ArrayList<Integer> newResult = new ArrayList<Integer>(oneResult);
            newResult.add(root);
            results.add(newResult);
        } else {
            oneResult.add(root);
            if(root.left != null)
                pathSum(root.left, sum - root.val, oneResult, results);
            if(root.right != null)
                pathSum(root.right, sum - root.val, oneResult, results);
            oneResult.remove(oneResult.size() - 1);
        }
    }  
    public boolean isLeaf(TreeNode node){
        return (node.left == null && node.right == null);
    }   
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}