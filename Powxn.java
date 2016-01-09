public class Powxn{
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        if(n == -1)
            return 1/x;
        double result = myPow(x, n/2);
        result *= result;
        if(n % 2 == 1)
            result *= x;
        else if(n % 2 == -1)
            result *= (1/x);
        return result;
    }    
}