package test.netease;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class StringSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        int len = string.length();
        int res = 0;
        int cur = 0;
        int[] dp = new int[32];
        Arrays.fill(dp, len);
        dp[0] = -1;
        for (int i = 0; i < len; i++) {
            int id = info(string.charAt(i));
            if (id >= 0) {
                cur = cur ^ (1 << id);
            }
            dp[cur] = Math.min(dp[cur], i);
            res = Math.max(res, i - dp[cur]);
        }
        System.out.println(res);
    }

    public static int info(char c) {
        if (c == 'a') {
            return 0;
        } else if (c == 'b') {
            return 1;
        } else if (c == 'c') {
            return 2;
        } else if (c == 'x') {
            return 3;
        } else if (c == 'y') {
            return 4;
        } else if (c == 'z') {
            return 5;
        } else {
            return -1;
        }
    }
}
