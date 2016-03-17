public class SummaryRange{
	public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums != null && nums.length > 0){
        	int start = 0;
        	for(int i = 1; i <= nums.length; i ++){
        		if(i == nums.length || nums[i] > nums[i-1] + 1){
        			if(start == i-1)
        				res.add(String.valueOf(nums[start]));
        			else
        				res.add(String.format("%d->%d", nums[start], nums[i-1]));
        			start = i;
        		}
        	}
        }
        return res;
    }
}