public class ReverseLinkedList{
    public ListNode reverseList(ListNode head) {
        return recursive(head);
    }    
    private ListNode iterative(ListNode head){
        ListNode next = null;
        ListNode cur = head;
        ListNode temp;
        while(cur != null){
            temp = cur.next;
            cur.next = next;
            next = cur;
            cur = temp;
        }
        return next;
    }
    private ListNode recursive(ListNode head){
        ListNode result = head;
        if(head != null && head.next != null){
            result = recursive(head.next);
            head.next.next = head;
            head.next = null;
        }
        return result;
    }
}