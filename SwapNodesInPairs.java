public class SwapNodesInPairs{
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode temp = head.next.next;
        head = head.next;
        head.next = cur;
        cur.next = temp;
        ListNode prev, next;
        while(temp != null && temp.next != null){
            prev = cur;
            cur = temp;
            next = temp.next;
            temp = next.next;
            prev.next = next;
            next.next = cur;
            cur.next = temp;
        }
        return head;
    }    
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}