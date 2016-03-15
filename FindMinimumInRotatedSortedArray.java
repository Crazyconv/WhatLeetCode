public class FindMinimumInRotatedSortedArray{
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[end])
                end = mid;
            else
                start = mid + 1;
        }
        return nums[start];
    }    
}