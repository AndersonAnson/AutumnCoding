package test.baidu;

import java.util.LinkedList;
import java.util.Scanner;

public class Step {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int oneFront = 0, twoFront = 0;
        int res = 0;
        for (int i = 1; i < m; i++) {
            oneFront = i;
            dfs(n, m, oneFront, twoFront, i, res);
        }
        System.out.println(res);
    }

    public static void dfs(int n, int m, int oneFront, int twoFront, int depth, int res) {
        if (depth == n) {
            res++;
            return;
        }
        int j = 1;
        while (j <= m) {
            if (j != oneFront && j != twoFront) {
                twoFront = oneFront;
                oneFront = j;
                dfs(n, m, oneFront, twoFront, depth + j, res);
            } else {
                j++;
            }
        }
    }
}
