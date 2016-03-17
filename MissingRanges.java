public class MissingRanges{
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        ArrayList<String> res = new ArrayList<String>();
        if(nums.length == 0)
        	addRange(res, lower - 1, upper + 1);
        else{
	        addRange(res, lower - 1, nums[0]);
	        for(int i = 1; i < nums.length; i ++)
	        	addRange(res, nums[i - 1], nums[i]);
	        addRange(res, nums[nums.length - 1], upper + 1);
	    }
        return res;
    }	
    public void addRange(ArrayList<String> res, int pre, int cur){
    	if(cur == pre + 2)
    		res.add(String.valueOf(pre + 1));
    	else if(cur > pre + 2)
    		res.add(String.format("%d->%d", pre + 1, cur - 1));
    }
}