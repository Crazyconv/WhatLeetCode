public class CountOfRangeSum{
    // merge sort
    // https://leetcode.com/discuss/79083/share-my-solution
    // general technique: two pointers -> property: monotonicity -> sorting
    // difference with general: position constraints -> update during sorting
    // 17 ms
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums == null || nums.length == 0 || lower > upper)
            return 0;

        long[] sums = new long[nums.length + 1];
        sums[0] = 0;
        for(int i = 0; i < nums.length; i++){
            sums[i+1] = sums[i] + (long)nums[i];
        }

        return mergeSort(sums, 0, sums.length - 1, (long)lower, (long)upper);      
    }
    int mergeSort(long[] sums, int start, int end, long lower, long upper){
        if(start < end){
            int count = 0;
            int mid = start + (end - start) / 2;
            count += mergeSort(sums, start, mid, lower, upper);
            count += mergeSort(sums, mid + 1, end, lower, upper);

            long [] temp = new long[end - start + 1];
            int lb = mid + 1, ub = mid + 1, R = mid + 1, s = 0;
            for(int i = start; i <= mid; i++){
                while(ub <= end && sums[ub] <= sums[i] + upper)
                    ub ++;
                while(lb <= end && sums[lb] < sums[i] + lower)
                    lb ++;
                count += (ub - lb);
                while(R <= end && sums[R] < sums[i])
                    temp[s++] = sums[R++];
                temp[s++] = sums[i];
            }
            for(int i = 0; i < s; i++){
                sums[i + start] = temp[i];
            }
            return count;
        }
        return 0;
    }

    // binary index tree
    // 31 ms
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums == null || nums.length == 0 || lower > upper)
            return 0;

        long[] sums = new long[nums.length + 1];
        sums[0] = 0;
        for(int i = 0; i < nums.length; i++){
            sums[i+1] = sums[i] + (long)nums[i];
        }

        long[] helper = sums.clone();
        Arrays.sort(helper);

        int count = 0;
        long[] tree = new long[sums.length + 1];
        for(int i = sums.length - 1; i >= 0; i--){
            int ui = findFirstLarger(helper, sums[i] + upper);
            int li = findFirstLargerOrEqual(helper, sums[i] + lower);
            if(ui > li){
                count += (sum(tree, ui) - sum(tree, li));
            }
            update(tree, Arrays.binarySearch(helper, sums[i]) + 1, 1);
        }
        return count;
    }

    public int findFirstLarger(long[] arr, long target){
        if(arr.length == 0)
            return -1;
        int start = 0, end = arr.length-1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] <= target)
                start = mid + 1;
            else
                end = mid;
        }
        if(arr[start] <= target)
            return arr.length;
        else
            return start;
    }

    public int findFirstLargerOrEqual(long[] arr, long target){
        if(arr.length == 0)
            return -1;
        int start = 0, end = arr.length-1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] < target)
                start = mid + 1;
            else
                end = mid;
        }
        if(arr[start] < target)
            return arr.length;
        else
            return start;        
    }

    public void update(long[] tree, int index, long value){
        while(index < tree.length){
            tree[index] += value;
            index += index & (-index);
        }
    }

    public long sum(long[] tree, int index){
        long ans = 0;
        while(index > 0){
            ans += tree[index];
            index -= index & (-index);
        }
        return ans;
    }

    // binary search tree
    // 79 ms
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums == null || nums.length == 0 || lower > upper)
            return 0;

        long[] sums = new long[nums.length + 1];
        sums[0] = 0;
        for(int i = 0; i < nums.length; i++){
            sums[i+1] = sums[i] + (long)nums[i];
        }

        int count = 0;
        BSTNode root = null;
        for(int i = sums.length - 1; i >= 0; i--){
            count += (countSmaller(root, sums[i] + upper, true) - countSmaller(root, sums[i] + lower, false));
            root = insert(root, sums[i]);
        }
        return count;
    }

    public int countSmaller(BSTNode root, long value, boolean inclusive){
        int count = 0;
        while(root != null){
            if(root.val == value){
                count += root.smaller;
                if(inclusive) count += root.duplicate;
                break;
            } else if(root.val < value){
                count += (root.smaller + root.duplicate);
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return count;
    } 
    public BSTNode insert(BSTNode root, long value){
        if(root == null)
            return new BSTNode(value);
        else{
            if(root.val == value)
                root.duplicate ++;
            else if(root.val < value)
                root.right = insert(root.right, value);
            else{
                root.smaller ++;
                root.left = insert(root.left, value);
            }
            return root;
        }
    }   

    public static void main(String[] argvs){
        CountOfRangeSum cors = new CountOfRangeSum();
        int[] nums = {2147483647,-2147483648,-1,0};
        System.out.println(cors.countRangeSum(nums, -2, 2));
    }
}

class BSTNode{
    long val;
    int smaller, duplicate;
    BSTNode left, right;
    public BSTNode(long val){
        this.val = val;
        smaller = 0;
        duplicate = 1;
        left = right = null;
    }
}