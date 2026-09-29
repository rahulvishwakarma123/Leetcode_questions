class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            // if price has dropped then we should buy it
            buy = Math.min(prices[i], buy);

            // ccalculate the profit and take it.
            profit = Math.max(profit, prices[i] - buy);
        }
        return profit;
    }
}