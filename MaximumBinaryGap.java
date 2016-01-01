// x & 1 = last digit of the x
public class MaximumBinaryGap{
    public int maximumBinaryGap(int N){
        int max = 0;
        int count = -1;
        int r = 0;
        while(N > 0){
            r = N & 1;
            N = N >> 1;
            if(r == 0 && count != -1)
                count ++;
            else if(r == 1){
                max = (max > count)? max:count;
                count = 0;
            }
        }
        return max;
    }
}