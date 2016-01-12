public class BestTimetoBuyandSellStockII{
    public int maxProfit(int[] prices) {
        int max = 0;
        if(prices != null && prices.length > 1){
            for(int i = 1; i < prices.length; i++){
                int diff = prices[i] - prices[i-1];
                if(diff > 0)
                    max += diff;
            }
        }
        return max;
    }    
}