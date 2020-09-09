package test.chinaTel;

import java.util.Scanner;

public class UglyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N == 1) {
            System.out.println(1);
        } else {
            int[] dp = new int[N];
            dp[0] = 1;
            int a2 = 0, a3 = 0, a5 = 0;
            for (int i = 1; i < N; i++) {
                int min = Math.min(2 * dp[a2], Math.min(3 * dp[a3], 5 * dp[a5]));
                if (min == dp[a2] * 2) {
                    a2++;
                }
                if (min == dp[a3] * 3) {
                    a3++;
                }
                if (min == dp[a5] * 5) {
                    a5++;
                }
                dp[i] = min;
            }
            System.out.println(dp[N - 1]);
        }

    }
}
