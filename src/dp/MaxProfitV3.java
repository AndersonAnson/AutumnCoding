package dp;

public class MaxProfitV3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int maxTradeNum = 2;
        int dayNum = prices.length;
        int[][][] dp = new int[dayNum][maxTradeNum + 1][2];
        for (int i = 0; i < dayNum; i++) {
            for (int j = maxTradeNum; j >= 1; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    // Ω‚ Õ£∫
                    //   dp[i][0]
                    // = max(dp[-1][0], dp[-1][1] + prices[i])
                    // = max(0, -infinity + prices[i]) = 0
                    dp[i][j][1] = -prices[i];
                    //   dp[i][1]
                    // = max(dp[-1][1], dp[-1][0] - prices[i])
                    // = max(-infinity, 0 - prices[i])
                    // = -prices[i]
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[dayNum - 1][maxTradeNum][0];
    }

    public int maxProfitV2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int s1 = -prices[0];
        int s2 = Integer.MIN_VALUE, s3 = Integer.MIN_VALUE, s4 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            s1 = Math.max(s1, -prices[i]);
            s2 = Math.max(s2, s1 + prices[i]);
            s3 = Math.max(s3, s2 - prices[i]);
            s4 = Math.max(s4, s3 + prices[i]);
        }
        return Math.max(0, s4);
    }
}
