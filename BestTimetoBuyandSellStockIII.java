public class BestTimetoBuyandSellStockIII{
    public int maxProfit(int[] prices) {
        int maxP = 0;
        if(prices != null && prices.length > 1){
            int[] earlier = int[prices.length];
            int min = prices[0];
            earlier[0] = 0;
            for(int i = 1; i < prices.length; i++){
                earlier[i] = (earlier[i-1] > prices[i] - min)? earlier[i-1] : prices[i] - min;
                min = (min < prices[i])? min : prices[i];
            }

            int[] later = int[prices.length];
            int max = prices[prices.length - 1];
            earlier[prices.length - 1] = 0;
            for(int i = prices.length - 2; i >= 0; i--){
                later[i] = (later[i+1] > max - prices[i])? later[i+1] : max - prices[i];
                max = (max > prices[i])? max : prices[i];
            }
            for(int i = 0; i < prices.length; i++){
                if(maxP < earlier[i] + later[i])
                    maxP = earlier[i] + later[i];
            }
        }
        return maxP;
    }    
}