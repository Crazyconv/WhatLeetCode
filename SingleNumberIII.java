// Two Pass
// 1: XOR all elements, get one of the bit set (get last bit in the solution)
// 2: divide all elements into two groups based on that bit, XOR each group
public class SingleNumberIII{
    public int[] singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i ++){
            result ^= nums[i];
        }
        // get last bit set
        result &= (0-result);
        int[] num = new int[2];
        for(int i = 0; i < nums.length; i ++){
            if((nums[i] & result) == 0)
                num[0] ^= nums[i];
            else
                num[1] ^= nums[i];
        }
        return num;
    }    
}