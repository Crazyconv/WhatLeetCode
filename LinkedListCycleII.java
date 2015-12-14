public class LinkedListCycleII{
    public ListNode detectCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while(second != null && second.next != null){
            first = first.next;
            second = second.next.next;
            if(first == second){
                first = head;
                while(first != second){
                    first = first.next;
                    second = second.next;
                }
                return first;
            }
        }
        return null;        
    }    
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}