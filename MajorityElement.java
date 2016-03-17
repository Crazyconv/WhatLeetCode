public class MajorityElement{
	// Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int count = 1, major = nums[0];
        for(int i = 1; i < nums.length; i++){
        	if(count == 0){
        		count = 1;
        		major = nums[i];
        	} else if (nums[i] != nums[i - 1]){
        		count --;
        	} else {
        		count ++;
        	}
        }
        return major;
    }	

    // bit manipulation
    public int majorityElement(int[] nums) {
    	int len = nums.length / 2;
    	int result = 0;
    	for(int i = 0, mask = 1; i < 32; i++, mask = (mask << 1)){
    		int count = 0;
    		for(int j = 0; j < nums.length; j++){
    			if((nums[j] & mask) != 0){
    				count ++;
    				if(count > len){
    					result |= mask;
    					break;
    				}
    			}
    		}
    	}
    	return result;
    }    
}