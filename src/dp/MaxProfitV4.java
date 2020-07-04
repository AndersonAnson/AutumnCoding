package dp;

public class MaxProfitV4 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int dayNum = prices.length;
        if (k > dayNum / 2) {
            int[][] dp = new int[dayNum][2];
            for (int i = 0; i < dayNum; i++) {
                if (i == 0) {
                    dp[0][0] = 0;
                    dp[0][1] = -prices[i];
                    continue;
                }
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[dayNum - 1][0];
        }
        int[][][] dp = new int[dayNum][k + 1][2];
        for (int i = 0; i < dayNum; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[dayNum - 1][k][0];
    }
}
