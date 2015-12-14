public class CopyListWithRandomPointer{
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode origin = head;
        RandomListNode result = new RandomListNode(0);
        RandomListNode cur = result;
        HashMap<RandomListNode, RandomListNode> hm = new HashMap<RandomListNode, RandomListNode>();
        while(origin != null){
            cur.next = new RandomListNode(origin.label);
            hm.put(origin, cur.next);
            origin = origin.next;
            cur = cur.next;
        }
        origin = head;
        cur = result.next;
        while(origin != null){
            cur.random = hm.get(origin.random);
            origin = origin.next;
            cur = cur.next;
        }
        return result.next;
    }    
}

class RandomListNode{
    int label;
    RandomListNode next, random;
    RandomListNode(int x){
        this.label = x;
    }
}