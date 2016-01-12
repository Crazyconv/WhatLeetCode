public class BestTimetoBuyandSellStock{
    public int maxProfit(int[] prices) {
        int max = 0;
        if(prices != null && prices.length > 1){
            int min = prices[0];
            for(int i = 1; i < prices.length; i++){
                if(max < prices[i] - min)
                    max = prices[i] - min;
                if(min > prices[i])
                    min = prices[i];
            }
        }
        return max;
    }    
}