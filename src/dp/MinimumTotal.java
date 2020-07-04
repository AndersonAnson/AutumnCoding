package dp;

import java.util.List;

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[][] dp = new int[row][col];
        dp[0][0] = triangle.get(0).get(0);
        int minVal = Integer.MAX_VALUE;
        for (int i = 1; i < row; i++) {
            List<Integer> lastLevelList = triangle.get(i - 1);
            List<Integer> levelList = triangle.get(i);
            for (int j = 0; j < levelList.size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + levelList.get(j);
                } else if (j == levelList.size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + levelList.get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + levelList.get(j);
                }
            }
        }
        for (int j = 0; j < col; j++) {
            minVal = Math.min(minVal, dp[row - 1][j]);
        }
        return minVal;
    }
}
