public class BurstBalloons{
    // https://leetcode.com/discuss/72216/share-some-analysis-and-explanations
    // reverse thinking in dp
    public int maxCoins(int[] nums) {
        int[] dup = new int[nums.length + 2];
        int size = 1;
        for(int n: nums){
            if(n > 0)
                dup[size ++] = n;
        }
        dup[0] = 1; dup[size ++] = 1;

        int[][] dp = new int[size][size];
        dp[0][0] = 1; dp[size - 1][size - 1] = 1;
        for(int length = 1; length <= size - 2; length ++){
            for(int start = 1; start + length <= size - 1; start ++){
                int end = start + length - 1;
                dp[start][end] = 0;
                for(int last = start; last <= end; last ++){
                    dp[start][end] = Math.max(dp[start][end], 
                        dp[start][last - 1] + dup[start - 1] * dup[last] * dup[end + 1] + dp[last + 1][end]);
                }
            }
        }
        return dp[1][size-2];
    }    
}