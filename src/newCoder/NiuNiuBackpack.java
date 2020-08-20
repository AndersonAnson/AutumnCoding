package newCoder;

import java.util.Scanner;

public class NiuNiuBackpack {
    public static long result = 1;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long w = sc.nextLong();
        long[] v = new long[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextLong();
        }
        dfs(v, 0, w, 0);
        System.out.println(result);
    }

    //0,1,1 2,1 2 4,1 4,2,2 4,4
    public static void dfs(long[] v, int index, long w, long current) {
        if (index == v.length) {
            return;
        }
        if (current + v[index] <= w) {
            result++;//当前这种添加方式合理,添加这件零食
            dfs(v, index + 1, w, current + v[index]);
        }
//    不添加这件零食
        dfs(v, index + 1, w, current);
    }
}
