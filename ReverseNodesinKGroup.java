public class ReverseNodesinKGroup{
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;

        // count number of nodes;
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            temp = temp.next;
            count ++;
        }

        int pass = count / k;
        ListNode dumpHead = new ListNode(0);
        ListNode lastTail = dumpHead;
        ListNode next = head;
        ListNode pre, cur, tail;
        for(int i = 0; i < pass; i++){
            pre = null;
            tail = next;
            for(int j = 0; j < k; j++){
                cur = next;
                next = next.next;
                cur.next = pre;
                pre = cur;
            }
            lastTail.next = pre;
            lastTail = tail;
        }
        lastTail.next = next;
        return dumpHead.next;
    }    
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}