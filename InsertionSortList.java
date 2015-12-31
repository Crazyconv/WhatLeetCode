public class InsertionSortList{
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode dumpHead = new ListNode(0);
        ListNode pre = dumpHead;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            pre = dumpHead;
            while(pre.next != null && pre.next.val < cur.val)
                pre = pre.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return dumpHead.next;
    }
    public static void main(String[] argvs){
        InsertionSortList sl = new InsertionSortList();
        ListNode head = new ListNode(3);
        ListNode node = head;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(4);
        head = sl.insertionSortList(head);
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