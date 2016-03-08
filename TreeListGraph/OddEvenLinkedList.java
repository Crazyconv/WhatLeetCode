public class OddEvenLinkedList{
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;
        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode evenTail = evenHead;
        ListNode next = evenHead.next;
        while(evenTail != null && evenTail.next != null){
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;
            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }
        oddTail.next = evenHead;
        return head;
    }    
}