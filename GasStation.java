public class GasStation{
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int end = 0;
        int sum = gas[start] - cost[start];
        while(start > end){
        	if(sum >= 0){
        		sum += gas[end] - cost[end];
        		end ++;
        	} else {
        		start --;
        		sum += gas[start] - cost[start];
        	}
        }
        return (sum >= 0)? start : -1;
    }	
    public int canCompleteCircuit(int[] gas, int[] cost){
    	// if station A cannot reach station B, all startions in between cannot reach B
    	// if sum of gas larger than sum of cost, there must be a solution
    	int start = 0;
    	int sum = 0;
    	int tank = 0;
    	for(int i = 0; i < gas.length; i++){
    		tank += gas[i] - cost[i];
    		if(tank < 0){
    			start = i + 1;
    			sum += tank;
    			tank = 0;
    		}
    	}
    	return (sum + tank < 0)? -1 : start;
    }
}