package test.pdd;

import java.util.Scanner;

public class BackPack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] weight = new int[N];
        int[] value = new int[N];
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                if (weight[i] < 0 && value[i] < 0 && weight[i] < value[i]) {
                    M = M + weight[i];
                }
                if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}
