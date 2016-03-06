// http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
// inorder, preorder, postorder in O(n) time and O(1) space
// recursive or iterative + stack taks O(n) space
// make use of the empty pointer of leaves, but recover it after use
import java.util.*;
public class MorrisTraversal{
    // in order
    // while cur != null:
    //     if cur.left == null: print, cur = cur.right
    //     else:
    //         pre = cur.left;
    //         while pre.right != null && pre.right != cur: pre = pre.right
    //         if pre.right == null: pre.right = cur, cur = cur.left
    //         else: pre.right = null, [print], cur = cur.right
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode cur = root, pre = null;
        while(cur != null){
            if(cur.left == null){
                result.add(cur.val);
                cur = cur.right;
            } else {
                pre = cur.left;
                while(pre.right != null && pre.right != cur)
                    pre = pre.right;
                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    result.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return result;
    }

    // pre order
    // just change the position of print
    // while cur != null:
    //     if cur.left == null: print, cur = cur.right
    //     else:
    //         pre = cur.left;
    //         while pre.right != null && pre.right != cur: pre = pre.right
    //         if pre.right == null: pre.right = cur, [print], cur = cur.left
    //         else: pre.right = null, cur = cur.right
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode cur = root, pre = null;
        while(cur != null){
            if(cur.left == null){
                result.add(cur.val);
                cur = cur.right;
            } else {
                pre = cur.left;
                while(pre.right != null && pre.right != cur)
                    pre = pre.right;
                if(pre.right == null){
                    result.add(cur.val);
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return result;
    }

    // post order
    // use a dump node, set left child to root
    // while cur != null:
    //     if cur.left == null: cur = cur.right
    //     else:
    //         pre = cur.left;
    //         while pre.right != null && pre.right != cur: pre = pre.right
    //         if pre.right == null: pre.right = cur, cur = cur.left
    //         else: pre.right = null, [print reverse(cur.left, pre)], cur = cur.right
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode cur = new TreeNode(0), pre = null;
        cur.left = root;
        while(cur != null){
            if(cur.left == null){
                cur = cur.right;
            } else {
                pre = cur.left;
                while(pre.right != null && pre.right != cur)
                    pre = pre.right;
                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    addReverse(cur.left, pre, result);
                    cur = cur.right;
                }
            }
        }
        return result;
    }
    public void addReverse(TreeNode from, TreeNode to, ArrayList<Integer> result){
        reverse(from, to);
        TreeNode cur = to;
        while(cur != null){
            result.add(cur.val);
            cur = cur.right;
        }
        reverse(to, from);
    }
    public void reverse(TreeNode from, TreeNode to){
        TreeNode pre = null;
        TreeNode cur = from;
        while(cur != null){
            TreeNode next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}