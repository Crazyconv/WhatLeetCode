public class IntersectionOfTwoLinkedLists{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        int lengthA = 0;
        int lengthB = 0;
        while(tempA != null){
            lengthA ++;
            tempA = tempA.next;
        }
        while(tempB != null){
            lengthB ++;
            tempB = tempB.next;
        }
        if(lengthA > lengthB){
            return check(headA, headB, lengthA - lengthB);
        } else {
            return check(headB, headA, lengthB - lengthA);
        }
    }
    public ListNode check(ListNode headA, ListNode headB, int diff){
        ListNode tempA = headA;
        ListNode tempB = headB;
        ListNode result = null;
        while(diff > 0){
            tempA = tempA.next;
            diff --;
        }
        while(tempA != null){
            if(tempA == tempB){
                if(result == null)
                    result = tempA;
            }
            else
                result = null;
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return result;
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