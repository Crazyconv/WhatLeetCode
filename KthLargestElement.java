import java.util.Random;
import java.util.PriorityQueue;
public class KthLargestElement{
    public static void main(String[] argvs){
        KthLargestElement kle = new KthLargestElement();
        int[] nums = {3, 1, 2, 4};
        System.out.println(kle.findKthLargest(nums, 2));
    }

    /* ========================================================================
     * =                               heap                                   =
     * ======================================================================== */
    // time O(nlgn) space O(1)
    public int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < k; i++){
            pq.offer(nums[i]);
        }
        for(int i = k; i < nums.length; i++){
            pq.offer(nums[i]);
            pq.poll();
        }
        return pq.peek();
    }

    /* ========================================================================
     * =                          quick selection                             =
     * ======================================================================== */
    // best O(n) worst O(n^2) space O(1)
    public int findKthLargest(int[] nums, int k){
        shuffle(nums);
        return innerFindKthLargest(nums, nums.length - k, 0, nums.length - 1);
    }
    public int innerFindKthLargest(int[] nums, int k, int start, int end){
        int pivot = nums[end];
        int i = start, j = end;
        // [start, i)  smaller
        // [j, end] larger
        while(i < j){
            while(nums[i] < pivot && i < j){
                i ++;
            }
            while(nums[j] >= pivot && i < j){
                j --;
            }
            if(i < j){
                swap(nums, i, j);
                i++;
            }
        }
        // after while loop, nums[j] >= pivot;
        swap(nums, i, end);
        if(i == k)
            return pivot;
        else if(i < k)
            return innerFindKthLargest(nums, k, i+1, end);
        else
            return innerFindKthLargest(nums, k, start, i-1);
    }
    public void shuffle(int[] nums){
        Random r = new Random();
        for(int i = nums.length - 1; i > 0; i--){
            int target = r.nextInt(i+1);
            swap(nums, i, target);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}