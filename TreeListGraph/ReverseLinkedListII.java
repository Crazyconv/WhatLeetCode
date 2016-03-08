public class ReverseLinkedListII{
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode preStart = null;
        ListNode start = head;
        int count = 1;
        while(count < m){
            count ++;
            preStart = start;
            start = start.next;
        }
        ListNode cur = start;
        ListNode next = null, temp = null;
        while(count <= n){
            count ++;
            temp = cur.next;
            cur.next = next;
            next = cur;
            cur = temp;
        }
        start.next = cur;
        if(preStart == null)
            head = next;
        else
            preStart.next = next;
        return head;
    }    
}