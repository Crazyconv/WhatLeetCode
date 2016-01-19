public class BulbSwitcher{
    // time limit exceed haha
    public int bulbSwitch(int n) {
        boolean[] state = new boolean[n+1];
        for(int i = 1; i <= n; i++){
            for(int j = i; j <= n; j += i){
                state[j] = !state[j];
            }
        }

        int count = 0;
        for(int i = 1; i <= n; i ++){
            if(state[i]) 
                count ++;
        }
        return count;
    }    

    // math magic!
    // the result is the number of integer (1 - n) which has odd factors
    // which is number of integers what are squares
    // because factors come in pairs 
    // sqrt is O(lgn)
    public int bulbSwitch(int n){
        return (int) Math.sqrt(n);
    }

    // binary search
    public int bulbSwitch(int n){
        if(n < 2)
            return n;
        long start = 1, end = n / 2;
        while(start < end){
            long mid = start + (end - start + 1) / 2;
            if(mid * mid <= n)
                start = mid;
            else 
                end = mid - 1;
        }
        return (int)start;
    }

    // O(1) solution
    // just use power and log to calculate sqrt
    // power and log in java is O(1)
    public int bulbSwitch(int n){
        return (int) Math.pow(2, 0.5 * (Math.log(n)/Math.log(2)));
    }
}