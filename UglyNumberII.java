public class UglyNumberII{
    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        int[] primes = new int[3];
        int[] index = new int[3];

        result[0] = 1;
        primes[0] = 2; primes[1] = 3; primes[2] = 5;
        for(int i = 1; i < n; i++){
            result[i] = Integer.MAX_VALUE;
            int id = 0;
            for(int j = 0; j < 3; j++){
                int can = primes[j] * result[index[j]];
                if(can == result[i-1]){ 
                    index[j]++;
                    can = primes[j] * result[index[j]];
                }
                if(result[i] > can){
                    result[i] = can;
                    id = j;
                }
            }
            index[id] ++;
        } 
        return result[n - 1];
    }
}