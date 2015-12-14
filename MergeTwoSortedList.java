public class MergeTwoSortedList{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode res = result;
        ListNode ll1 = l1, ll2 = l2;
        while(true){
            if(ll1 == null){
                result.next = ll2;
                break;
            }
            if(ll2 == null){
                result.next = ll1;
                break;
            }
            if(ll1.val < ll2.val){
                result.next = ll1;
                result = result.next;
                ll1 = ll1.next;
            } else {
                result.next = ll2;
                result = result.next;
                ll2 = ll2.next;
            }
        }
        return res.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}