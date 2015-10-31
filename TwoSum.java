import java.util.HashMap;

public class TwoSum{
    public static void main(String[] argvs){
        TwoSum ts = new TwoSum();
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] solutions = ts.twoSumSorted(nums, target);
        System.out.println(solutions[0] + ", " + solutions[1]);
    }

    public int[] twoSum(int[] nums, int target){
        int[] solutions = new int[2];
        HashMap<Integer, Integer> m = new HashMap();
        for(int i = 0; i < nums.length; i ++){
            Integer index = m.get(target - nums[i]);
            if(index != null){
                solutions[0] = index + 1;
                solutions[1] = i + 1;
                break;
            } else {
                m.put(nums[i], i);
            }
        }
        return solutions;
    }
    public int[] twoSumSorted(int[] nums, int target){
        int[] solutions = new int[2];
        int i = 0, j = nums.length - 1;
        while(i != j){
            if(nums[i] + nums[j] == target){
                solutions[0] = i + 1;
                solutions[1] = j + 1;
                break;
            } else if (nums[i] + nums[j] > target){
                j --;
            } else {
                i ++; 
            }
        }
        return solutions;
    }
}