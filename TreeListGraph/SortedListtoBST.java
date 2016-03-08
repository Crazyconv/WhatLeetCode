public class SortedListtoBST{
    ListNode h; 
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        int length = getLength(head);
        h = head;
        return TreeNode sortedListToBST(0, length - 1);
    }
    public getLength(ListNode head){
        int l = 0;
        while(head != null){
            l ++;
            head = head.next;
        }
        return l;
    }
    public TreeNode sortedListToBST(int start, int end){
        if(end < start)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode t = new TreeNode(0);
        t.left = sortedListToBST(start, mid - 1);
        t.val = h.val;
        h = h.next;
        t.right = sortedListToBST(mid + 1, end);
        return t;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}