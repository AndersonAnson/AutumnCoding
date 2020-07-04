package dp;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int minVal = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minVal) {
                minVal = prices[i];
            }
            if (prices[i] - minVal > dp[i - 1]) {
                dp[i] = prices[i] - minVal;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[prices.length - 1];
    }

    public int maxProfitV2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
