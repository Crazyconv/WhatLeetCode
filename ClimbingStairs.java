public class ClimbingStairs{
    public int climbStairs(int n) {
        if(n <= 0)
            return 0;
        if(n <= 2)
            return n;

        int f1 = 1, f2 = 2;
        while(n >= 3){
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
            n--;
        }

        return f2;
    }    
}