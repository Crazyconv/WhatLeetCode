public class CountPrimes{
    public int countPrimes(int n) {
        if(n <= 2)
            return 0;
        boolean[] isComposite = new boolean[n/2];
        for(int i = 3; i * i < n; i += 2){
            if(!isComposite[i/2]){
                for(int j = i * i; j < n; j += i){
                    if(j % 2 == 1)
                        isComposite[j/2] = true;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n/2; i++){
            if(!isComposite[i])
                count ++;
        }
        return count;
    }
    public static void main(String[] argvs){
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(13));
        System.out.println(cp.countPrimes(10));
    }
}