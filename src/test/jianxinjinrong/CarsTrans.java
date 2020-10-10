package test.jianxinjinrong;

import java.util.Arrays;

public class CarsTrans {
    public int carsTrans(int[] cars, int num) {
        // write code here
        Arrays.sort(cars);
        int max = num + 1;
        int[] dp = new int[num + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < cars.length; j++) {
                if (cars[j] <= i) {
                    dp[i] = Math.min(dp[i - cars[j]] + 1, dp[i]);
                }
            }
        }
        if (dp[num] > num) {
            return -1;
        } else {
            return dp[num];
        }
    }
}
