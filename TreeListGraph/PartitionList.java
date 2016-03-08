public class PartitionList{
    public ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode(0);
        ListNode second = new ListNode(0);
        ListNode firstCur = first;
        ListNode secondCur = second;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                firstCur.next = cur;
                firstCur = firstCur.next;
                cur = cur.next;
                firstCur.next = null;
            } else {
                secondCur.next = cur;
                secondCur = secondCur.next;
                cur = cur.next;
                secondCur.next = null;
            }
        }
        if(first.next == null)
            return second.next;
        else{
            firstCur.next = second.next;
            return first.next;
        }
    }    
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}