//Use n=n&(n-1) trick to clear the least bit
public class NumberOfOneBits{
    public int hammingWeight(int n){
        int count = 0;
        for(; n!= 0; n &= (n-1)){
            count ++;
        }
        return count;
    }
}