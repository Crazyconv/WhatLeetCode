public class LRUCache {
    int num;
    int capacity;
    ListNode fakeHead;
    ListNode fakeTail;
    HashMap<Integer, ListNode> hm;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        num = 0;
        fakeHead = new ListNode(0, 0);
        fakeTail = new ListNode(0, 0);
        fakeHead.next = fakeTail;
        fakeTail.prev = fakeHead;
        hm = new HashMap<Integer, ListNode>();
    }
    
    public int get(int key) {
        ListNode lastUsed = hm.get(key);
        if(lastUsed == null)
            return -1;

        lastUsed.prev.next = lastUsed.next;
        lastUsed.next.prev = lastUsed.prev;

        fakeTail.prev.next = lastUsed;
        lastUsed.prev = fakeTail.prev;
        lastUsed.next = fakeTail;
        fakeTail.prev = lastUsed;
        return lastUsed.val;
    }
    
    public void set(int key, int value) {
        ListNode lastUsed = hm.get(key);
        if(lastUsed == null){
            lastUsed = new ListNode(key, value);
            hm.put(key, lastUsed);
            if(num < capacity){
                num++;                
            } else {
                hm.remove(fakeHead.next.key);
                fakeHead.next = fakeHead.next.next;
                fakeHead.next.prev = fakeHead;
            }
        } else {
            lastUsed.prev.next = lastUsed.next;
            lastUsed.next.prev = lastUsed.prev;
            lastUsed.val = value;
        }
        fakeTail.prev.next = lastUsed;
        lastUsed.prev = fakeTail.prev;
        lastUsed.next = fakeTail;
        fakeTail.prev = lastUsed;            
    }
}

class ListNode {
    int key;
    int val;
    ListNode prev, next;
    ListNode(int key, int val){
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}