package algorithmComplexity;

public class TestComplexity {
    public void test1() {
        int a = 100;
        int b = a;
        System.out.println(a);
        System.out.println(b);
    }

    public void test2(int n) {
        int a = 100;
        for (int i = 1; i <= n; i++) {
            System.out.println(a);
            System.out.println(i);
        }
    }

    public void test3(int n) {
        boolean flag = true;
        if (flag) {
            int a = 100;
            for (int i = 1; i <= n; i++) {
                System.out.println(i);
            }
        } else {
            int a = 200;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.println(j);
                }
            }
        }
    }

    public int test4(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public void testN(int n) {
        for (int i = 1; i < n; i++) {
            int j = 1;
            while (j < n) {
                j = j * 2;
            }
        }
    }

    public int recursion(int n) {
        if (n <= 1) {
            return 1;
        }
        return recursion(n - 1) + recursion(n - 2);
    }

}
