public class GrayCode{
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> re = new ArrayList<Integer>();
        re.add(0);
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < re.size(); j++){
        		re.set(j, re.get(j) + (0 << i));
        	}
        	for(int j = re.size() - 1; j >= 0; j--){
        		re.add(re.get(j) + (1 << i));
        	}
        }
        return re;
    }	

    // https://en.wikipedia.org/wiki/Gray_code
    public int binaryToGray(int num){
    	return num ^ (num >> 1);
    }

    public int grayToBinary(int num){
    	int mask;
    	for(mask = num >> 1; mask != 0; mask = mask >> 1)
    		num ^= mask;
    	return num;
    }
}