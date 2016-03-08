public class RemoveDuplicatesfromSortedList{
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = head;
        if(head != null){
            ListNode pre = result;
            ListNode cur = result.next;
            while(cur != null){
                if(cur.val == pre.val){
                    pre.next = cur.next;
                } else {
                    pre = cur;
                }
                cur = cur.next;
            }
        }
        return result;
    }    
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}