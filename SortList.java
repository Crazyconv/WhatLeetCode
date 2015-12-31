public class SortList{
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;

        slow = sortList(head);
        fast = sortList(fast);

        ListNode dumpHead = new ListNode(0);
        ListNode pre = dumpHead;
        while(slow != null && fast != null){
            if(slow.val < fast.val){
                pre.next = slow;
                pre = pre.next;
                slow = slow.next;
            } else {
                pre.next = fast;
                pre = pre.next;
                fast = fast.next;
            }
        }
        if(slow != null){
            pre.next = slow;
        }
        if(fast != null){
            pre.next = fast;
        }
        return dumpHead.next;
    }
    public static void main(String[] argvs){
        SortList sl = new SortList();
        ListNode head = new ListNode(3);
        ListNode node = head;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(4);
        head = sl.sortList(head);
        while(head != null){
            System.out.printf("%d ", head.val);
            head = head.next;
        }
    }    
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}