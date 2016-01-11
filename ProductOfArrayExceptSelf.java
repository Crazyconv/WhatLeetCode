public class ProductOfArrayExceptSelf{
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i --){
            result[i] = result[i+1] * nums[i+1];
        }

        int left = nums[0];
        for(int i = 1; i < nums.length; i++){
            result[i] *= left;
            left *= nums[i];
        }  
        return result; 
    }    
}