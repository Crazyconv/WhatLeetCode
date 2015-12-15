public class RemoveLinkedListElements{
    public ListNode removeElements(ListNode head, int val) {
        while(true){
            if(head == null)
                return head;
            else if(head.val == val)
                head = head.next;
            else
                break;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                cur.next = null;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
    }    
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}