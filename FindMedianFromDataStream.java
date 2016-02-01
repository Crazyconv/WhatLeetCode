public class FindMedianFromDataStream{
    /* =============================================================== *
     *                              BST                                *
     * =============================================================== */
    TreeNode root = null;
    int n = 0;
    // Adds a number into the data structure.
    public void addNum(int num) {
        root = addNum(root, num);
        n++;
    }

    public TreeNode addNum(TreeNode root, int num){
        if(root == null)
            return new TreeNode(num);
        if(root.val == num)
            root.duplicate ++;
        else if(root.val > num){
            root.leftNum ++;
            root.left = addNum(root.left, num);
        } else {
            root.rightNum ++;
            root.right = addNum(root.right, num);
        }
        return root;
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(n % 2 == 1)
            return (double) find(root, (n + 1) / 2);
        else
            // may overflow
            return ((double) find(root, (n + 1) / 2) + (double) find(root, (n + 1) / 2 + 1)) / 2;
    }

    public int find(TreeNode root, int k){
        int leftInclusive = root.leftNum + root.duplicate;
        if(leftInclusive >= k){
            if(root.leftNum >= k)
                return find(root.left, k);
            else
                return root.val;
        } else 
            return find(root.right, k - leftInclusive);
    }   


    /* =============================================================== *
     *                             heap                                *
     * =============================================================== */
    Queue<Integer> smallerHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
        public int compare(Integer i1, Integer i2){
            return Integer.compare(i2, i1);
        }
    });
    Queue<Integer> largerHeap = new PriorityQueue<Integer>();

    boolean balance = true;

    // Adds a number into the data structure.
    public void addNum(int num) {
        largerHeap.add(num);
        smallerHeap.add(largerHeap.poll());
        if(!balance)
            largerHeap.add(smallerHeap.poll());
        balance = !balance;
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(smallerHeap.size() == largerHeap.size())
            return (smallerHeap.peek() + largerHeap.peek()) / 2.0;
        else
            return smallerHeap.peek();
    }
}

class TreeNode{
    int val;
    int duplicate, leftNum, rightNum;
    TreeNode left, right;
    public TreeNode(int val){
        this.val = val;
        duplicate = 1;
        leftNum = rightNum = 0;
        left = right = null;
    }
}