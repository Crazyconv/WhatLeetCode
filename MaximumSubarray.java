public class MaximumSubarray{
    // DP
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int lastMax = nums[0];
        int max = lastMax;
        for(int i = 1; i < nums.length; i ++){
            if(lastMax > 0)
                lastMax += nums[i];
            else
                lastMax = nums[i];
            if(max < lastMax)
                max = lastMax;
        }
        return max;
    }  
    // divide and conquer
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] result = maxSubArray(nums, 0, nums.length - 1);
        return result[1];
    }

    public int[] maxSubArray(int[] nums, int start, int end){
        int[] result = new int[4];
        if(start == end){
            result[0] = nums[start]; // sum
            result[1] = nums[start]; // largest sum
            result[2] = nums[start]; // largest sum starting from start
            result[3] = nums[start]; // largest sum ending in end
        } else {
            int mid = start + (end - start) / 2;
            int[] left = maxSubArray(nums, start, mid);
            int[] right = maxSubArray(nums, mid + 1, end);
            result[0] = left[0] + right[0];
            result[1] = (left[1] > right[1])? left[1] : right[1];
            if(result[1] < left[3] + right[2])
                result[1] = left[3] + right[2];
            result[2] = (left[0] - left[2] + right[2] > 0)? left[0] + right[2] : left[2];
            result[3] = (right[0] - right[3] + left[3] > 0)? right[0] + left[3] : right[3];
        }
        return result;
    }

}