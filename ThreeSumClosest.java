import java.util.Arrays;
public class ThreeSumClosest{
    public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int absDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i ++){
            int targetDiff = target - nums[i];
            int j = i+1, k = nums.length - 1;
            while(j < k){
                int diff = (nums[j] + nums[k]) - targetDiff;
                if(diff == 0)
                    return target;
                else if(absDiff > Math.abs(diff)){
                    absDiff = Math.abs(diff);
                    minDiff = diff;
                }
                if(diff > 0){
                    k--;
                } else {
                    j++;
                }
            }
        }
        return target + minDiff;
    }
    public static void main(String[] argvs){
        ThreeSumClosest tsc = new ThreeSumClosest();
        int[] nums = {-1, 2, 1, -4};
        System.out.println(tsc.threeSumClosest(nums, 1));
    }
}