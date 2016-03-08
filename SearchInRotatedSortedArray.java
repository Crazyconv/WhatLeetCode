public class SearchInRotatedSortedArray{
    // method 1: find smallest value first
    public int search(int[] nums, int target) {
        if(nums != null && nums.length > 0){
            int lo = 0, hi = nums.length - 1;
            while(lo < hi){
                int mid = lo + (hi - lo) / 2;
                if(nums[mid] > nums[hi]){
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            int rot = lo;
            lo = 0; hi = nums.length - 1;
            if(target == nums[hi])
                return hi;
            else if(target > nums[hi]){
                lo = 0;
                hi = rot - 1;
            } else {
                lo = rot;
                hi = hi - 1;
            }
            while(lo <= hi){
                int mid = lo + (hi - lo) / 2;
                if(nums[mid] == target){
                    return mid;
                } else if (nums[mid] < target){
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }                
            }
        }
        return -1;
    }    

    // one binary search
    public int search(int[] nums, int target) {
        if(nums != null && nums.length > 0){
            int lo = 0, hi = nums.length - 1;
            while(lo <= hi){
                int mid = lo + (hi - lo) / 2;
                if(nums[mid] == target)
                    return mid;

                if(nums[mid] < nums[hi]){
                    // lo..start..mid..hi
                    if(target > nums[mid] && target <= nums[hi])
                        lo = mid + 1;
                    else
                        hi = mid - 1;
                } else {
                    // lo..mid..start..hi
                    if(target >= nums[lo] && target < nums[mid])
                        hi = mid - 1;
                    else
                        lo = mid + 1;
                }
            }
        }
        return -1;
    }
}