import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
public class MergeKSortedList{
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }
    public ListNode mergeKLists(ListNode[] lists, int start, int end){
        if(start == end)
            return lists[start];
        if(start == end - 1)
            return mergeTwoLists(lists[start], lists[end]);
        int mid = start + (end - start)/2;
        return mergeTwoLists(mergeKLists(lists, start, mid), mergeKLists(lists, mid+1, end));
    }
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
    public static void main(String[] argvs){
        MergeKSortedList msl = new MergeKSortedList();
        ListNode[] lists = new ListNode[5];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[1] = new ListNode(-1);
        lists[1].next = new ListNode(0);
        lists[2] = new ListNode(3);
        lists[2].next = new ListNode(5);
        lists[3] = new ListNode(2);
        lists[3].next = new ListNode(6);
        lists[4] = null;
        ListNode result = msl.mergeKLists(lists);
        while(result != null){
            System.out.printf("%d ", result.val);
            result = result.next;
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