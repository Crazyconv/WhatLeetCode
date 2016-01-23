public class RangeSumQueryImmutable{
    int[] sum;
    public RangeSumQueryImmutable(int[] nums) {
        if(nums != null && nums.length > 0){
            sum = new int[nums.length+1];
            for(int i = 1; i <= nums.length; i++){
                sum[i] = sum[i - 1] + nums[i - 1];
            }
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }    
}