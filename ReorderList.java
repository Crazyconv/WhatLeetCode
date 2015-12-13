public class ReorderList{
    // public void reorderList(ListNode head) {
    //     ArrayList<ListNode> nums = new ArrayList<ListNode>();
    //     ListNode start = head;
    //     while(start != null){
    //         nums.add(start);
    //         start = start.next;
    //     }
    //     start = head;
    //     int index = nums.size() - 1;
    //     if(index <= 1)
    //         return;
    //     ListNode tail = nums.get(index);
    //     while(start != tail && start.next != tail){
    //         tail.next = start.next;
    //         start.next = tail;
    //         start = tail.next;
    //         tail = nums.get(--index);
    //     }
    //     tail.next = null;
    // } 
    public void reorderList(ListNode head){
        if(head != null && head.next != null && head.next.next != null){
            ListNode first = head, second = head;
            while(second != null && second.next != null && second.next.next != null){
                first = first.next;
                second = second.next.next;
            }
            second = first.next;
            first.next = null;
            first = head;
            second = reverse(second);
            merge(first, second);
        }
    }
    public ListNode reverse(ListNode head){
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next = null;
        return pre;
    } 
    public void merge(ListNode first, ListNode second){
        while(second != null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
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