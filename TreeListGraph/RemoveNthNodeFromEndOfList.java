public class RemoveNthNodeFromEndOfList{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(n > 0){
            fast = fast.next;
            n --;
        }
        while(fast != null){
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev != null){
            prev.next = slow.next;
        } else {
            head = slow.next;
        }
        slow.next = null;
        return head;
    }    
}