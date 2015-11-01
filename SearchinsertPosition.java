public class SearchinsertPosition{
    public static void main(String[] argvs){
        SearchinsertPosition s = new SearchinsertPosition();
        int[] nums = {1,3,5,6};
        System.out.println(s.searchInsert(nums, 5));
        System.out.println(s.searchInsert(nums, 2));
        System.out.println(s.searchInsert(nums, 7));
        System.out.println(s.searchInsert(nums, 0));
    }
    public int searchInsert(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return 0;
        int start = 0, end = nums.length - 1;
        while(start < end){
            int mid = (end - start)/2 + start;
            if(nums[mid] >= target){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if(nums[start] < target)
            return nums.length;
        else
            return start;
    }
}