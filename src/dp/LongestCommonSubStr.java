package dp;

public class LongestCommonSubStr {
    public int longestCommonSubStr(String a, String b) {
        if (a.length() == 0 || b.length() == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[a.length()][b.length()];//二维数组默认为0
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubStr().longestCommonSubStr("hdakwdajlq","lczdakwdmdk"));
    }
}
