public class JumpGameII{
    public int jump(int[] nums) {
        int i = 0;
        int step = 0; 
        int farthest = 0;
        int nextFarthest = 0;
        while(true){
            if(farthest >= nums.length - 1)
                return step;
            if(i <= farthest){
                if(nextFarthest < i + nums[i])
                    nextFarthest = i + nums[i];
                i++;
            } else {
                farthest = nextFarthest;
                step ++;
            }
        }
    }    
}