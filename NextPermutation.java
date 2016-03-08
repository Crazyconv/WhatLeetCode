// https://leetcode.com/discuss/8472/share-my-o-n-time-solution
public class NextPermutation{
    public void nextPermutation(int[] nums) {
        if(nums != null && nums.length > 1){
            int i = nums.length - 1;
            for(; i > 0; i--){
                if(nums[i] > nums[i - 1]){
                    break;
                }
            }
            // i ~ n - 1 is reversed sort
            if(i != 0){
                int j = nums.length - 1;
                while (j >= i){
                    if(nums[j] > nums[i - 1])
                        break;
                    j --;
                }
                swap(nums, i - 1, j);
                // after this i ~ n - 1 is still reversed sort;
            }
            reverse(nums, i, nums.length - 1);
        }
    }   
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start ++;
            end --;
        }
    }
}