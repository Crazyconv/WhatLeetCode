public class RemoveDuplicatesfromSortedArrayII{
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3)
            return nums.length;
        int dupNum = 0;
        int pre = nums[0];
        int count = 0;
        for(int j = 1; j < nums.length; j++){
            int cur = nums[j];
            if(cur == pre){
                count ++;
                if(count >= 2)
                    dupNum ++;
                else
                    nums[j-dupNum] = nums[j];
            }
            else{
                count = 0;
                nums[j-dupNum] = nums[j];
                pre = cur;
            }
        }
        return nums.length - dupNum;
    }    
}