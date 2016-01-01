// good explanation of the solution: https://leetcode.com/discuss/6632/challenge-me-thx
// generalization of the problem: https://leetcode.com/discuss/6632/challenge-me-thx
public class SingleNumberII{
    public int singleNumber(int[] nums) {
        int x1 = 0, x0 = 0, mask = 0;
        for(int i = 0; i < nums.length; i++){
            x1 ^= (nums[i] & x0);
            x0 ^= nums[i];
            mask = ~(x1 & x0);
            x1 &= mask;
            x0 &= mask;
        }
        return x0;
    }    
}