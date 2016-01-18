import java.util.*;
public class CountofSmallerNumbersAfterSelf{
    // merge sort
    // the smaller numbers on the right of a number are exactly those that
    // jump from its right to its left during a stable sort
    // using numIdx as just index rather than an object containing both value and index is faster
    // 13 ms
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<Integer>();

        int len = nums.length;
        int[] result = new int[len];
        int[] numIdx = new int[len];
        for(int i = 0; i < len; i++){
            numIdx[i] = i;
            result[i] = 0;
        }

        mergeSort(nums, numIdx, result, 0, len - 1);

        ArrayList<Integer> res = new ArrayList<Integer>(len);
        for(int i : result)
            res.add(i);
        return res;
    }

    public void mergeSort(int[] nums, int[] numIdx, int[] result, int start, int end){
        if(end > start){
            int mid = start + (end - start) / 2;
            mergeSort(nums, numIdx, result, start, mid);
            mergeSort(nums, numIdx, result, mid + 1, end);

            int[] temp = new int[end - start + 1];
            int L = start, R = mid + 1, i = 0, smaller = 0;
            while(L <= mid || R <= end){
                if(R == end + 1 || L <= mid && nums[numIdx[L]] <= nums[numIdx[R]]){
                    result[numIdx[L]] = result[numIdx[L]] + smaller;
                    temp[i++] = numIdx[L++];
                } else {
                    smaller ++;
                    temp[i++] = numIdx[R++];
                }
            }
            for(int j = 0; j < temp.length; j++){
                numIdx[start + j] = temp[j];
            }
        }
    }

    // divide and conquer based on bit by bit comparison
    // https://leetcode.com/discuss/74994/nlogn-divide-and-conquer-java-solution-based-bit-comparison
    // check size of smaller and larger before calling function is faster
    // 45 ms
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<Integer>();

        int len = nums.length;
        int[] result = new int[len];
        ArrayList<Integer> idx = new ArrayList<Integer>(len);
        for(int i = len - 1; i >= 0; i--){
            idx.add(i);
            result[i] = 0;
        }

        bitCompare(nums, idx, 1 << 31, result);

        ArrayList<Integer> res = new ArrayList<Integer>(len);
        for(int i : result)
            res.add(i);
        return res;
    } 

    public void bitCompare(int[] nums, ArrayList<Integer> idx, int mask, int[] result){
        if(mask != 0){
            int higherBit = (mask < 0) ? 0 : mask;
            ArrayList<Integer> smaller = new ArrayList<Integer>(idx.size());
            ArrayList<Integer> larger = new ArrayList<Integer>(idx.size());
            for(int i = 0; i < idx.size(); i++){
                int n = idx.get(i);
                if((nums[n] & mask) == higherBit){
                    result[n] += smaller.size();
                    larger.add(n);
                } else {
                    smaller.add(n);
                }
            } 
            if(smaller.size() > 1)
                bitCompare(nums, smaller, mask >>> 1, result);
            if(larger.size() > 1)
                bitCompare(nums, larger, mask >>> 1, result);
        }
    } 

    // binary search tree
    // traverse from the back to the beginning of the array
    // maintain BST of numbers that have been visited
    // simple BST is O(n^2)
    // 8 ms
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<Integer>();

        int len = nums.length;
        int[] result = new int[len];
        BSTNode root = new BSTNode(nums[len - 1]);
        result[len - 1] = 0;

        for(int i = len - 2; i >= 0; i--){
            result[i] = insert(root, nums[i], 0);
        }

        ArrayList<Integer> res = new ArrayList<Integer>(len);
        for(int i : result)
            res.add(i);
        return res;        
    }

    public int insert(BSTNode root, int val, int sum){
        if(root.val == val){
            root.duplicate ++;
            return sum + root.smaller;
        } else if (root.val < val){
            if(root.right != null)
                return insert(root.right, val, sum + root.smaller + root.duplicate);
            else {
                root.right = new BSTNode(val);
                return sum + root.smaller + root.duplicate;
            }
        } else {
            root.smaller ++;
            if(root.left != null)
                return insert(root.left, val, sum);
            else {
                root.left = new BSTNode(val);
                return sum;
            }
        }
    }

    // binary search tree
    // use TreeSet
    // time limit exceed, because headSet is O(n)
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<Integer>();

        int len = nums.length;
        int[] result = new int[len];
        TreeSet<Helper> t = new TreeSet<Helper>();

        for(int i = len - 1; i >= 0; i--){
            Helper h = new Helper(nums[i], i);
            result[i] = t.headSet(h).size();
            t.add(h);
        }

        ArrayList<Integer> res = new ArrayList<Integer>(len);
        for(int i : result)
            res.add(i);
        return res;        
    }

    // binary index tree
    // using a helper array
    // https://leetcode.com/discuss/73233/complicated-segmentree-solution-hope-to-find-a-better-one
    // 18 ms
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<Integer>();

        int len = nums.length;
        int[] result = new int[len];

        int[] helper = nums.clone();
        Arrays.sort(helper);
        for(int i = 0; i < len; i++){
            nums[i] = Arrays.binarySearch(helper, nums[i]) + 1;
        }

        int[] tree = new int[len + 1];
        for(int i = len - 1; i >= 0; i--){
            result[i] = sum(tree, nums[i] - 1);
            update(tree, nums[i], 1);
        }

        ArrayList<Integer> res = new ArrayList<Integer>(len);
        for(int i : result)
            res.add(i);
        return res;        
    }

    public void update(int[] tree, int index, int value){
        int len = tree.length;
        while(index < len){
            tree[index] += value;
            index += (index & (-index));
        }
    }

    public int sum(int[] tree, int index){
        int res = 0;
        while(index > 0){
            res += tree[index];
            index -= (index & (-index));
        }
        return res;
    }

    // binary index tree
    // using idea of count sort
    // https://leetcode.com/discuss/78460/172ms-python-bitree-solution-beats-99-07%25
    // risk of overflow (java array has a max size of Integer.MAX_VALUE - 5)

    // segment tree
    // similar idea to binary index tree

}
class NumIdx{
    int value;
    int index;
    public NumIdx(int value, int index){
        this.value = value;
        this.index = index;
    }
}

class BSTNode{
    int val;
    int smaller;
    int duplicate;
    BSTNode left;
    BSTNode right;
    public BSTNode(int val){
        this.val = val;
        this.smaller = 0;
        this.duplicate = 1;
        this.left = null;
        this.right = null;
    }
}

class Helper implements Comparable<Helper>{
    int value;
    int index;
    public Helper(int value, int index){
        this.value = value;
        this.index = index;
    }
    public int compareTo(Helper h){
        if(this.value < h.value)
            return -1;
        else if(this.value > h.value)
            return 1;
        else if(this.index < h.index)
            return -1;
        else if(this.index > h.index)
            return 1;
        else 
            return 0;
    }
}