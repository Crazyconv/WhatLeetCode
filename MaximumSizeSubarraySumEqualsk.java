public class MaximumSizeSubarraySumEqualsk{
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int sum = 0;
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum == k)
                maxLen = i + 1;
            else if(m.get(sum - k) != null){
                int len = i - m.get(sum - k);
                if(maxLen < len) maxLen = len;
            }    
            if(m.get(sum) == null){
                m.put(sum, i);
            }
        }
        return maxLen;
    }    
}