public class RemoveDuplicatesfromSortedListII{
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        result.next = head;
        while(cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                int val = cur.next.val;
                while(cur.next != null && cur.next.val == val){
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return result.next;
    }    
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}