// https://leetcode.com/discuss/77133/o-n-o-1-after-median-virtual-indexing
// https://leetcode.com/discuss/77115/o-n-time-o-1-space-solution-with-detail-explanations
// https://leetcode.com/discuss/78592/java-18-ms-true-o-1-space-cheated-o-n-time-using-binary-search
public class WiggleSortII{
    public void wiggleSort(int[] nums) {
        if(nums != null && nums.length > 1){
            // binary search in integer range to find the median, 17ms
            // use KthLargestElement takes 130+ ms
            int median = findMedian(nums, nums.length / 2);

            // virtual indexing
            int len = (nums.length | 1);
            int gt = 0;
            int lt = nums.length - 1;
            int i = 0;
            while(i <= lt){
                int vi = (1 + 2 * i) % len;
                if(nums[vi] > median){
                    int vgt = (1 + 2 * gt) % len;
                    swap(nums, vi, vgt);
                    gt ++;
                    i ++;
                } else if(nums[vi] < median){
                    int vlt = (1 + 2 * lt) % len;
                    swap(nums, vi, vlt);
                    lt --;
                } else {
                    i++;
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findMedian(int[] nums, int k){
        int left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
        while(left <= right){
            int mid = (left + right) / 2;
            int lt = 0, gt = 0, d = 0;
            for(int n: nums){
                if(n < mid){
                    if(++lt > k){
                        d = 1; // mid too large
                        break;
                    }
                } else if(n > mid){
                    if(++gt > k){
                        d = -1; // mid too small
                        break;
                    }
                } 
            } 
            if(d == 0)
                return mid;
            else if(d > 0){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }   
}