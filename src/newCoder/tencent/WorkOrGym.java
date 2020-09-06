package newCoder.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class WorkOrGym {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] work = new int[n];
        int[] gym = new int[n];
        for (int i = 0; i < n; i++) {
            work[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            gym[i] = sc.nextInt();
        }
//        画个状态机，一目了然.. dp[i][0] , dp[i][1], dp[i][2] 分别记录第i天 休息/锻炼/工作 累计的最小休息天数.. 状态转移关系如下图..
        int[][] dp = new int[n + 1][3];// 0是休息，1是锻炼，2是工作
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = 63;
            }
        }
        dp[0][0] = dp[0][1] = dp[0][2] = 0;
        for (int i = 1; i <= n; i++) {
            if (gym[i - 1] == 1) {
                // 第i天锻炼的最小休息天数就等于i-1天工作或者i-1天休息中取最小的那个
                dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][0]);
            }
            if (work[i - 1] == 1) {
                // 第i天工作的最小休息天数就等于i-1天锻炼或者i-1天休息中取最小的那个
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]);
            }
            dp[i][0] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])) + 1;
        }
        int res = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
        System.out.println(res);
    }
}
