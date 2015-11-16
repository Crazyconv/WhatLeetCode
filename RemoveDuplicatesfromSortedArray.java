public class RemoveDuplicatesfromSortedArray{
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2)
            return nums.length;
        int dupNum = 0;
        int pre = nums[0];
        for(int j = 1; j < nums.length; j++){
            int cur = nums[j];
            if(cur == pre)
                dupNum ++;
            else{
                nums[j-dupNum] = nums[j];
                pre = cur;
            }
        }
        return nums.length - dupNum;
    }    
}