public class FindPeakElement{
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start < end - 1){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else if(nums[mid] < nums[mid - 1])
                end = mid - 1;
            else 
                start = mid + 1;
        }
        return (nums[start] > nums[end])? start : end;
    }
    public static void main(String[] argvs){
        int[] nums = {2,3};
        System.out.println((new FindPeakElement()).findPeakElement(nums));
    }    
}