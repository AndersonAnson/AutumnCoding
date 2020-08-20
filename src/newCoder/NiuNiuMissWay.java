package newCoder;

import java.util.Scanner;

public class NiuNiuMissWay {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'L') {
                dp[i + 1] = dp[i] - 1;
                if (dp[i + 1] == -1) {
                    dp[i + 1] = 3;
                }
            } else {
                dp[i + 1] = dp[i] + 1;
                if (dp[i + 1] == 4) {
                    dp[i + 1] = 0;
                }
            }
        }
        if (dp[N] == 0) {
            System.out.println("N");
        } else if (dp[N] == 1) {
            System.out.println("E");
        } else if (dp[N] == 2) {
            System.out.println("S");
        } else {
            System.out.println("W");
        }
    }
}
