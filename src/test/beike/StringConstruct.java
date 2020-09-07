package test.beike;

import java.util.Scanner;

public class StringConstruct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String string = sc.next();

        if (n == 1) {
            System.out.println(1);
        } else if (n == 2) {
            System.out.println(2);
        } else {
//            boolean copy = false;
//            int[] dp = new int[n + 1];
//            dp[0] = 0;
//            dp[1] = 1;
//            dp[2] = 2;
//            for (int i = 3; i <= n; i++) {
//                if (i % 2 == 0) {
//                    String firstHalf = string.substring(0, i / 2);
//                    String secondHalf = string.substring(i / 2, i);
//                    if (firstHalf.equals(secondHalf) && copy == false) {
//                        if (dp[i - 1] + 1 > dp[i / 2] + 1) {
//                            dp[i] = dp[i / 2] + 1;
//                            copy = true;
//                        } else {
//                            dp[i] = dp[i - 1] + 1;
//                        }
//                    } else {
//                        dp[i] = dp[i - 1] + 1;
//                    }
//                } else {
//                    dp[i] = dp[i - 1] + 1;
//                }
//            }
//            System.out.println(dp[n]);
            int step = 0;
            int point = 0;
            for (int i = n - 1; i >= 0; i--) {
                if ((i + 1) % 2 == 0) {
                    String firstHalf = string.substring(0, (i + 2) / 2);
                    String secondHalf = string.substring((i + 2) / 2, i + 1);
                    if (firstHalf.equals(secondHalf)) {
                        step++;
                        point = i;
                        break;
                    } else {
                        step++;
                    }
                } else {
                    step++;
                }
            }
            step = step + (point + 1) / 2;
            System.out.println(step);
        }

    }
}
