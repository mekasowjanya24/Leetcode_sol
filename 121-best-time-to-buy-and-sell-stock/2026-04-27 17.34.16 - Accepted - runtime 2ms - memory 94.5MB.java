class Solution {
    public int maxProfit(int [] prices) {
        int profit=0;
        int min_1=prices[0];
        for(int i=1;i<prices.length;i++){
            int cost=prices[i]-min_1;
            profit=Math.max(profit,cost);
            min_1=Math.min(min_1,prices[i]);
        }
        return profit;
    }
}