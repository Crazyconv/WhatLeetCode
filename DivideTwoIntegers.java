public class DivideTwoIntegers{
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if(dividend == 0)
            return 0;

        long dd = (long) dividend;
        long ds = (long) divisor;
        boolean negative = false;
        if(dd < 0){
            dd = 0 - dd;
            negative = !negative;
        }
        if(ds < 0){
            ds = 0 - ds;
            negative = !negative;
        }

        int result = 0;
        while(dd >= ds){
            int count = 0;
            long temp = (ds << 1);
            while(dd >= temp){
                temp = (temp << 1);
                count ++;
            }
            result += (1 << count);
            dd -= (temp >> 1);
        }
        if(negative)
            result = 0 - result;
        return result;
    }    
}