package dp;

public class longestCommonSubSequence {
    public int longestCommonSubSequence(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    public int longestCommonSubSequenceV2(String a, String b, int i, int j) {
        if (i < 0 || j < 0) {//i,j入参是字符串最大长度-1
            return 0;
        }
        if (a.charAt(i) == b.charAt(j)) {
            return longestCommonSubSequenceV2(a, b, i - 1, j - 1) + 1;
        } else {
            return Math.max(longestCommonSubSequenceV2(a, b, i - 1, j), longestCommonSubSequenceV2(a, b, i, j - 1));
        }
    }
}
