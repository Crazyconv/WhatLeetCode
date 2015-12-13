public class AddTwoNumbers{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = null;
        ListNode cur = null;
        int carry = 0, d1 = 0, d2 = 0, sum = 0;
        while(l1 != null || l2 != null){
            d1 = (l1 == null)? 0:l1.val;
            d2 = (l2 == null)? 0:l2.val;
            sum = d1 + d2 + carry;
            if(sum >= 10){
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            if(result == null){
                result = new ListNode(sum);
                cur = result;
            } else {
                cur.next = new ListNode(sum);
                cur = cur.next;
            }
            l1 = (l1 == null)? null: l1.next;
            l2 = (l2 == null)? null: l2.next;
        }
        if(carry != 0)
            cur.next = new ListNode(carry);
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}