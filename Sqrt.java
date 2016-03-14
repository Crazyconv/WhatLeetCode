public class Sqrt{
    public int mySqrt(int x) {
        if(x == 1 || x == 0)
        	return x;
        long long lx = (long long) x;
        long long start = 1, end = lx / 2;
        while(start < end){
        	long long mid = start + (end - start + 1)/2;
        	if(mid * mid == lx)
        		return (int) mid;
        	else if(mid * mid < lx)
        		start = mid;
        	else 
        		end = mid - 1;
        }
        return (int) start;
    }	

    // use divide instead of multiple to avoid overflow

    public int mySqrt(int x){
    	if(x == 1 || x == 0)
    		return x;
    	int start = 1, end = x / 2;
    	while(start < end){
    		int mid = start + (end - start) / 2;
    		if(mid > x / mid)
    			end = mid - 1;
    		else if((mid + 1) > x / (mid + 1))
    			return mid;
    		else 
    			start = mid + 1;
    	}
    	return start;
    }
}