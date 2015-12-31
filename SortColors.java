public class SortColors{
    public void sortColors(int[] nums) {
        if(nums != null && nums.length != 0){
            int redIndex = 0;
            int blueIndex = nums.length - 1;
            int i = 0;
            while(i <= blueIndex){
                if(nums[i] == 0){
                    swap(nums, i, redIndex);
                    redIndex ++;
                    i++;
                } else if(nums[i] == 2){
                    swap(nums, i, blueIndex);
                    blueIndex --;
                } else {
                    i++;
                }
            }
        }
    }   
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    } 
}