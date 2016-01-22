public class SuperUglyNumber{
    // method 1: min heap
    // actually because of duplicate time complexity is still O(nk);
    // use hashset to avoid duplicates
    // 94ms
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] result = new int[n];
        result[0] = 1;
        PriorityQueue<UglyNumber> heap = new PriorityQueue<UglyNumber>();
        HashSet<Integer> added = new HashSet<Integer>();
        for(int p : primes){
            heap.add(new UglyNumber(p, p, 0));
        }

        for(int i = 1; i < n; i ++){
            UglyNumber un = heap.poll();
            result[i] = un.num;
            int nextPost = un.pos + 1;
            int next = result[nextPost] * un.prime;
            while(added.contains(next)){
                next = result[++ nextPost] * un.prime;
            }
            added.add(next);
            heap.add(new UglyNumber(un.prime, next, nextPost));
        }
        return result[n-1];        
    }  

    // we can also limit the generator sequence to be increasing
    // 24ms
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] result = new int[n];
        int[] generator = new int[n];
        result[0] = 1;
        generator[0]= 1;
        PriorityQueue<UglyNumber> heap = new PriorityQueue<UglyNumber>();
        for(int p : primes){
            heap.add(new UglyNumber(p, p, 0));
        }

        for(int i = 1; i < n; i ++){
            UglyNumber un = heap.poll();
            result[i] = un.num;
            generator[i] = un.prime;
            int nextPost = un.pos + 1;
            while(generator[nextPost] > un.prime){
                nextPost ++;
            }
            heap.add(new UglyNumber(un.prime, result[nextPost] * un.prime, nextPost));
        }
        return result[n-1];        
    }       

    // method 2: similar to ugly number II
    // O(nk)
    // 26 ms
    public int nthSuperUglyNumber(int n, int[] primes){
        int[] result = new int[n];
        int[] index = new int[primes.length];

        result[0] = 1;
        for(int i = 1; i < n; i++){
            result[i] = Integer.MAX_VALUE;
            int id = 0;
            for(int j = 0; j < primes.length; j++){
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

class UglyNumber implements Comparable<UglyNumber>{
    int prime;
    int num;
    int pos;
    public UglyNumber(int prime, int num, int pos){
        this.prime = prime;
        this.num = num;
        this.pos = pos;
    }
    public int compareTo(UglyNumber u){
        if(num < u.num)
            return -1;
        else if(num > u.num)
            return 1;
        else
            return 0;
    }
}