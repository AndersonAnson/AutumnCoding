package dp;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        String ans = "";
        if (len < 2)
            return s;
        int begin = 0;
        int end = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for (int j = 1; j <= len - 1; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] == true) {
                    if (j - i + 1 > end - begin) {
                        begin = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(begin, end + 1);
    }
}
