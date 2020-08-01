package swordToOffer;

public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index == 1)
            return 0;
        if (index == 0)
            return 0;
        int[] dp = new int[index];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < index; i++) {
            int min = Math.min(2 * dp[i2], Math.min(3 * dp[i3], 5 * dp[i5]));
            if (min == dp[i2] * 2) {
                i2++;
            }
            if (min == dp[i3] * 3) {
                i3++;
            }
            if (min == dp[i5] * 5) {
                i5++;
            }
            dp[i] = min;
        }
        return dp[index - 1];
    }

    public int GetUglyNumber_SolutionV2(int index) {
        if (index <= 0) return 0;
        int p2 = 0, p3 = 0, p5 = 0;//初始化三个指向三个潜在成为最小丑数的位置
        int[] result = new int[index];
        result[0] = 1;//
        for (int i = 1; i < index; i++) {
            result[i] = Math.min(result[p2] * 2, Math.min(result[p3] * 3, result[p5] * 5));
            if (result[i] == result[p2] * 2) p2++;//为了防止重复需要三个if都能够走到
            if (result[i] == result[p3] * 3) p3++;//为了防止重复需要三个if都能够走到
            if (result[i] == result[p5] * 5) p5++;//为了防止重复需要三个if都能够走到


        }
        return result[index - 1];
    }
}
