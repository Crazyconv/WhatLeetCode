public class MajorityElementII{
    public List<Integer> majorityElement(int[] nums) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	if(nums != null && nums.length > 0){
	        // for each vote down, three distinct numbers are removed.
	        // thus, if a majority element exists, it must remain in the end
	        int can1 = 0, can2 = 1, count1 = 0, count2 = 0;
	        for(int i = 0; i < nums.length; i++){
	        	if(nums[i] == can1)
	        		count1 ++;
	        	else if(nums[i] == can2)
	        		count2 ++;
	        	else if(count1 == 0){
	        		count1 = 1;
	        		can1 = nums[i];
	        	} else if(count2 == 0){
	        		count2 = 1;
	        		can2 = nums[i];
	        	} else {
	        		count1 --;
	        		count2 --;
	        	}
	        }
	        count1 = 0;
	        count2 = 0;
	        for(int i = 0; i < nums.length; i++){
	        	if(nums[i] == can1)
	        		count1 ++;
	        	else if(nums[i] == can2)
	        		count2 ++;
	        }
	        if(count1 > nums.length / 3) res.add(can1);
	        if(count2 > nums.length / 3) res.add(can2);
	    }
	    return res;
    }	
}