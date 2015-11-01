public class MinSizeSubArraySum{
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, minSize = nums.length + 1, sum = 0;
        while(right < nums.length){
            while(sum < s && right < nums.length){
                sum += nums[right];
                right ++;
            }
            while(sum >= s){
                minSize = Math.min(minSize, right - left);
                if(minSize == 1)
                    return 1;
                sum -= nums[left];
                left++;
            }
        }
        return (minSize == nums.length + 1)? 0 : minSize;
    }
    public static void main(String[] argvs){
        MinSizeSubArraySum mssas = new MinSizeSubArraySum();
        int[] nums = {1, 1};
        System.out.println(mssas.minSubArrayLen(3, nums));
    }    
}