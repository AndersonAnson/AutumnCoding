package test.jd;

import java.util.LinkedList;
import java.util.Scanner;

public class BallGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        if (rows == 1) {
            System.out.println(sc.nextInt());
        } else {
            int[] nums = new int[rows * rows];
            int[] dp = new int[rows * rows];
            int ans = 0;
            while (sc.hasNextInt()) {
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = sc.nextInt();
                }
                int rowFlag = 1;
                dp[0] = nums[0];
                for (int i = 1; i < dp.length; i++) {
                    if (i == rowFlag * rowFlag) {
                        rowFlag++;
                    }
                    if (i == rowFlag * rowFlag - 1) {
                        dp[i] = dp[i - 2 * (rowFlag - 1) - 1] + nums[i];
                    } else if (i == (rowFlag - 1) * (rowFlag - 1)) {
                        dp[i] = dp[i - 2 * (rowFlag - 1) + 1] + nums[i];
                    } else if (i == (rowFlag - 1) * (rowFlag - 1) + 1) {
                        dp[i] = Math.max(dp[i - 2 * (rowFlag - 1)] + nums[i], dp[i - 2 * (rowFlag - 1) + 1] + nums[i]);
                    } else if (i == rowFlag * rowFlag - 2) {
                        dp[i] = Math.max(dp[i - 2 * (rowFlag - 1)] + nums[i], dp[i - 2 * (rowFlag - 1) - 1] + nums[i]);
                    } else {
                        dp[i] = Math.max(dp[i - 2 * (rowFlag - 1)] + nums[i], Math.max(dp[i - 2 * (rowFlag - 1) - 1] + nums[i], dp[i - 2 * (rowFlag - 1) + 1] + nums[i]));
                    }
                    ans = Math.max(ans, dp[i]);
                }
                System.out.println(ans);
            }

        }
    }
}
