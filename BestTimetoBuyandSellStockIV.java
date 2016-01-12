public class BestTimetoBuyandSellStockIV{
    /* dp[i,j]: max profit till day j with at most i transactions
     * dp[i,j] = max(dp[i, j-1], dp[i-1,m] + price[j] - price[m]) (m = 0 ~ j-1)
     * dp[i,0] = 0
     * dp[0,j] = 0
     */
    public int maxProfit(int k, int[] prices) {
        int maxP = 0;
        if(k > 0 && prices != null && prices.length > 1){
            // if k > n/2, can do maximum transaction
            if(k > n/2){
                for(int i = 1; i < prices.length; i ++){
                    int diff = prices[i] - prices[i - 1];
                    if(diff > 0)
                        maxP += diff;
                }
            } else {
                int[][] dp = new int[k + 1][prices.length];
                for(int i = 1; i < k + 1; i ++){
                    int localMax = dp[i-1][0] - prices[0];
                    for(int j = 1; j < prices.length; j ++){
                        dp[i][j] = Math.max(dp[i][j-1], prices[j] + localMax);
                        localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
                    }
                }
                maxP = dp[k][prices.length - 1];
            }
        }
        return maxP;
    }    
}