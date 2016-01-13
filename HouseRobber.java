public class HouseRobber{
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int lastLast = nums[0];
        int last = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            int cur = Math.max(last, lastLast + nums[i]);
            lastLast = last;
            last = cur;
        }
        return last;
    }    
}