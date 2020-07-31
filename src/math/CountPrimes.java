package math;

import java.util.Arrays;

public class CountPrimes {
    public int countPrimes(int n) {
        int result = 0;
        boolean[] b = new boolean[n];   // 初始化默认值都为 false，为质数标记
        if (2 < n) result++; // 如果大于 2 则一定拥有 2 这个质数

        for (int i = 3; i < n; i += 2) {  // 从 3 开始遍历，且只遍历奇数
            if (!b[i]) {  // 是质数
                for (int j = 3; i * j < n; j += 2) {
                    b[i * j] = true;    // 将当前质数的奇数倍都设置成非质数标记 true
                }
                result++;   // 质数个数 +1
            }
        }
        return result;
    }

    public int countPrimesV2(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                for (int j = i * i; j < n; j = j + i) {
                    isPrim[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i > n; i++) {
            if (isPrim[i]) {
                count++;
            }
        }
        return count;
    }

}
