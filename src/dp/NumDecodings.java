package dp;

public class NumDecodings {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0)
            return 0;
        int[] dp = new int[len];
        // dp[i] 以 s[i] 结尾的前缀子串有多少种解码方法
        // dp[i] = dp[i - 1] * 1 if s[i] != '0'
        // dp[i] += dp[i - 2] * 1 if  10 <= int(s[i - 1..i]) <= 26
        char[] charArray = s.toCharArray();
        if (charArray[0] == '0') {
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (charArray[i] != '0') {
                dp[i] = dp[i - 1];
            }
            int num = 10 * (Integer.valueOf(String.valueOf(charArray[i - 1]))) + Integer.valueOf(String.valueOf(charArray[i]));
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] = dp[i] + dp[i - 2];
                }
            }
        }
        return dp[len - 1];
    }
}

