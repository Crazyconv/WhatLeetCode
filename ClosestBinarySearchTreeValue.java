public class ClosestBinarySearchTreeValue{
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        TreeNode toCheck = (closest > target)? root.left:root.right;
        if(toCheck != null){
            int kidClosest = closestValue(toCheck, target);
            closest = (Math.abs(closest - target) < Math.abs(kidClosest - target))? closest : kidClosest;
        }
        return closest;
    }
}