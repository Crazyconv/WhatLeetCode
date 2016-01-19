public class CoinChange{
    // dp + DFS
    // 44 ms
    // use hashmap instead of array takes 186 ms....
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        if(coins.length == 0)
            return -1;

        int[] m = new int[amount + 1];
        m[0] = 0;
        for(int i = 1; i <= amount; i++)
            m[i] = -2;
        Arrays.sort(coins);
        coinChange(coins, amount, m);
        return m[amount];
    }    
    public void coinChange(int[] coins, int amount, int[] m){
        int count = -1;
        for(int i = 0; i < coins.length && coins[i] <= amount; i++){
            if(m[amount - coins[i]] == -2)
                coinChange(coins, amount - coins[i], m);
            if(m[amount - coins[i]] != -1){
                if(count == -1 || count > m[amount - coins[i]] + 1)
                    count = m[amount - coins[i]] + 1;
            }

        }
        m[amount] = count;
    }

    // with prone
    // 1. combination rather than permutation
    // 2. jianzhi
    // 5 ms
    int minCount = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        if(coins.length == 0)
            return -1;

        Arrays.sort(coins);
        coinChange(coins, amount, coins.length - 1, 0);
        return minCount == (Integer.MAX_VALUE)? -1:minCount;
    }
    public void coinChange(int[] coins, int amount, int index, int prev){
        if(index < 0) return;

        int dup = amount/coins[index];
        for(int i = dup; i >= 0; i--){
            int remain = amount - i * coins[index];
            int count = prev + i;
            if(remain > 0 && count < minCount)
                // no repeatitive work because the later one will fail "count < minCount"
                coinChange(coins, remain, index - 1, count);
            else if(remain == 0){
                if(count < minCount) minCount = count;
            } else {
                // clever
                break;
            }
        }
    }    

    // BFS
    // 48 ms
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        if(coins.length == 0)
            return -1;

        Arrays.sort(coins);
        LinkedList<Integer> pre = new LinkedList<Integer>();
        LinkedList<Integer> cur = new LinkedList<Integer>();
        boolean[] visited = new boolean[amount];
        visited[amount - 1] = true;
        pre.offer(amount);
        int count = 1;

        while(pre.size() > 0){
            while(pre.size() > 0){
                int val = pre.remove();
                for(int i = coins.length - 1; i >=0; i --){
                    if(val == coins[i])
                        return count;
                    else if(val > coins[i]){
                        int remain = val - coins[i];
                        if(!visited[remain - 1]){
                            visited[remain - 1] = true;
                            cur.offer(remain);
                        }
                    }
                }
            }
            pre = cur;
            cur = new LinkedList<Integer>();
            count ++;
        }
        return -1;
    }    
}