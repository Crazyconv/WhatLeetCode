public class BestTimetoBuyandSellStockWithCooldown{
    // public int maxProfit(int[] prices) {
    //     // buy[i]: maxProfit in day i if day i buys
    //     // sell[i]: maxProfit in day i if day j sells
    //     // buy[i] = max(sell[0]...sell[i-2]) - prices[i]
    //     // sell[i] = max(buy[0]...buy[i-1]) + prices[i]
    //     if(prices == null || prices.length < 2)
    //         return 0;
    //     int[] buy = new int[prices.length];
    //     int[] sell = new int[prices.length];
    //     buy[0] = 0 - prices[0];
    //     buy[1] = 0 - prices[1];
    //     sell[0] = 0;
    //     int maxBuy = buy[0];
    //     int maxSell = sell[0];
    //     int maxP = 0;
    //     for(int i = 1; i < prices.length; i++){
    //         if(i != 1){
    //             buy[i] = maxSell - prices[i];
    //             maxSell = Math.max(maxSell, sell[i-1]);
    //         }
    //         sell[i] = maxBuy + prices[i];
    //         maxBuy = Math.max(maxBuy, buy[i]);
    //         if(sell[i] > maxP)
    //             maxP = sell[i];
    //     }  
    //     return maxP;
    // }
    public int maxProfit(int[] prices) {
        // buy[i]: maxProfit in day i if sequence ends in buy
        // sell[i]: maxProfit in day i if sequence ends in sell
        // buy[i] = max(buy[i-1], sell[i-2] - prices[i])
        // sell[i] = max(sell[i-1], buy[i-1] + prices[i])
        // buy[0] = -prices[0]
        // buy[1] = max(-prices[0], -prices[1])
        // sell[0] = 0
        if(prices == null || prices.length < 2)
            return 0;
        int lastBuy = 0 - prices[0]; // i = 0
        int lastSell = 0; // i = 0
        int lastLastSell = 0;
        for(int i = 1; i < prices.length; i++){
            // buy
            int buy = (i == 1)? Math.max(lastBuy, 0 - prices[i]) : Math.max(lastBuy, lastLastSell - prices[i]);
            int sell = Math.max(lastSell, lastBuy + prices[i]);
            lastBuy = buy;
            lastLastSell = lastSell;
            lastSell = sell;
        }
        return lastSell;
    }
}