public class ClosestBinarySearchTreeValueII{
    // https://leetcode.com/discuss/71820/java-5ms-iterative-following-hint-o-klogn-time-and-space
    // https://leetcode.com/discuss/55486/java-two-stacks-iterative-solution
    // step 1: find the largest element <= target, and the smallest element > target
    // step 2: merge: keep finding the next largest element and smallest element
    // lgn + klgn
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> smaller = new Stack<TreeNode>();
        Stack<TreeNode> larger = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null){
            if(cur.val <= target){
                smaller.push(cur);
                cur = cur.right;
            } else {
                larger.push(cur);
                cur = cur.left;
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        while(k-- != 0){
            if(smaller.size() == 0 || larger.size() != 0 && larger.peek().val - target < target - smaller.peek().val){
                // add larger
                result.add(larger.peek().val);
                cur = larger.pop().right;
                while(cur != null){
                    larger.push(cur);
                    cur = cur.left;
                }
            } else {
                // add smaller
                result.add(smaller.peek().val);
                cur = smaller.pop().left;
                while(cur != null){
                    smaller.push(cur);
                    cur = cur.right;
                }
            }
        }
        return result;
    }

    // in-order traversal
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        traversal(root, target, k, result);
        return result;
    }

    public boolean traversal(TreeNode root, double target, int k, LinkedList<Integer> result){
        if(root == null)
            return false;

        // prone
        if(traversal(root.left, target, k, result))
            return true;

        if(result.size() == k){
            if(Math.abs(result.get(0) - target) < Math.abs(root.val - target))
                return true;
            else
                result.removeFirst();
        }
        result.add(root.val);
        return traversal(root.right, target, k, result);
    }
}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}