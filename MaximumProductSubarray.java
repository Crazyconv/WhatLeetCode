public class MaximumProductSubarray{
    public int maxProduct(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int maxPos = 0;
        int maxNeg = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                maxPos = maxNeg = 0;
            } else if(nums[i] > 0){
                maxPos = (maxPos > 1)? maxPos * nums[i] : nums[i];
                maxNeg = maxNeg * nums[i];
            } else {
                int temp = (maxPos > 1)? maxPos * nums[i] : nums[i];
                maxPos = maxNeg * nums[i];
                maxNeg = temp;
            }
            if(max < maxPos)
                max = maxPos;
        }
        return max;
    }  
    public static void main(String[] argvs){
        MaximumProductSubarray mps = new MaximumProductSubarray();
        int[] a = {-4, -3};
        mps.maxProduct(a);
    }  
}