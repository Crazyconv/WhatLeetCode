public class RotateList{
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null)
            return head;
        else{
            // count length
            ListNode tail = head;
            int len = 1;
            while(tail.next != null){
                tail = tail.next;
                len ++;
            }
            tail.next = head; // make a cycle

            k %= len;
            if(k != 0){
                len -= (k % len);
                tail = head;
                while(--len){
                    tail = tail.next;
                }
                head = tail.next;
                tail.next = null;
            }
            return head;
        }
    }    
}