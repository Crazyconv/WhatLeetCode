public class FactorialTrailingZeroes{
    public int trailingZeroes(int n) {
        int result = 0;
        while(n >= 5){
            result += (n = n/5);
        }
        return result;
    }    
}