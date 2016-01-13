public class JumpGame{
    public boolean canJump(int[] nums) {
        if(nums != null && nums.length > 0){
            int fathest = 0;
            int i = 0;
            while(i <= fathest){
                if(fathest >= nums.length - 1)
                    return true;
                if(fathest < i + nums[i])
                    fathest = i + nums[i];
                i++;
            }
        }
        return false;
    }    
}