public class LongestIncreasingSubsequence{
    public int lengthOfLIS(int[] nums) {
        int len = 0;
        if(nums != null && nums.length != 0){
            int[] lis = new int[nums.length];

            lis[0] = 0;
            len = 1;
            for(int i = 1; i < nums.length; i++){
                if(nums[i] < nums[lis[0]]){
                    lis[0] = i;
                } else if(nums[i] > nums[lis[len - 1]]){
                    lis[len] = i;
                    len ++;
                } else {
                    int next = findFirstLargerInclusive(nums, lis, 0, len, nums[i]);
                    lis[next] = i;
                }
            }
        }
        return len;
    }
    public int findFirstLargerInclusive(int[] nums, int[] lis, int start, int end, int target){
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[lis[mid]] < target)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
}