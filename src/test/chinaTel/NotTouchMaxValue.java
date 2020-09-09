package test.chinaTel;

import java.util.Scanner;

public class NotTouchMaxValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String[] cur = input.split(",");
        int len = cur.length;
        if (len == 1) {
            System.out.println(cur[0]);
        } else {
            int[] dp = new int[len];
            boolean selected = true;
            dp[0] = Integer.valueOf(cur[0]);
            dp[1] = Math.max(Integer.valueOf(cur[0]), Integer.valueOf(cur[1]));
            for (int i = 2; i < dp.length; i++) {
                dp[i] = Math.max(dp[i - 2] + Integer.valueOf(cur[i]), dp[i - 1]);
            }
            System.out.println(dp[len - 1]);
        }

    }
}
