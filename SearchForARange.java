public class SearchForARange{
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = result[1] = -1;
        if(nums != null && nums.length > 0){
            int lo = 0, hi = nums.length - 1;
            while(lo <= hi){
                int mid = lo + (hi - lo) / 2;
                if(nums[mid] == target){
                    result[0] = result[1] = mid;
                    search(nums, target, result, lo, mid - 1, true);
                    search(nums, target, result, mid + 1, hi, false);
                    break;
                } else if (nums[mid] > target){
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return result;
    }    
    public void search(int[] nums, int target, int[] result, int lo, int hi, boolean left){
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target){
                if(left){
                    result[0] = mid;
                    hi = mid - 1;
                } else {
                    result[1] = mid;
                    lo = mid + 1;
                }
            } else {
                if(left) 
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
    }

    // two binary search to find the low and high respectively
    // find the first >= and the last <=

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int left = findFirstLarger(nums, target, true);
        if(left == nums.length || nums[left] != target){
            result[0] = -1;
            result[1] = -1;
        } else {
            result[0] = left;
            result[1] = findFirstLarger(nums, target, false) - 1;
        }
        return result;
    }

    public int findFirstLarger(int[] nums, int target, boolean equal){
        int lo = 0, hi = nums.length;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(target < nums[mid]){
                hi = mid;
            } else if(target > nums[mid]){
                lo = mid + 1;
            } else if(equal){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

    // divide and conquer
    // prof of lgn: https://leetcode.com/discuss/40921/9-11-lines-o-log-n
    public int[] searchRange(int[] nums, int target) {
        return searchRange(nums, target, 0, nums.length - 1);
    }

    public int[] searchRange(int[] nums, int target, int lo, int hi){
        int[] result = new int[2];
        if(target == nums[lo] && target == nums[hi]){
            result[0] = lo;
            result[1] = hi;
        } else if(target < nums[lo] || target > nums[hi]){
            result[0] = -1;
            result[1] = -1;
        } else{
            int mid = lo + (hi - lo) / 2;
            int[] left = searchRange(nums, target, lo, mid);
            int[] right = searchRange(nums, target, mid + 1, hi);
            if(left[0] == -1) return right;
            if(right[0] == -1) return left;
            result[0] = left[0];
            result[1] = right[1];
        }
        return result;
    }    
}