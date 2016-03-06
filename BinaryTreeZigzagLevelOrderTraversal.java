public class BinaryTreeZigzagLevelOrderTraversal{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root != null){
            ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
            cur.add(root);
            boolean leftToRight = true;
            while(cur.size() != 0){
                int size = cur.size();
                ArrayList<TreeNode> next = new ArrayList<TreeNode>();
                ArrayList<Integer> item = new ArrayList<Integer>();
                for(int i = 0; i < size; i++){
                    item.add(0);
                }
                for(int i = 0; i < size; i++){
                    TreeNode node = cur.get(i);
                    if(node.left != null)
                        next.add(node.left);
                    if(node.right != null)
                        next.add(node.right);
                    int index = leftToRight? i : size - 1 - i;
                    item.set(index, node.val);
                }

                result.add(item);
                cur = next;
                leftToRight = !leftToRight;
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