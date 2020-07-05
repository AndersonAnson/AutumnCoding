package dp;

public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int temp = 1;
        for (int i = 1; i < n; i++) {
            temp = Math.min(2 * nums[i2], Math.min(3 * nums[i3], 5 * nums[i5]));
            nums[i] = temp;
            if (temp == nums[i2] * 2) {
                i2++;
            }
            if (temp == nums[i3] * 3) {
                i3++;
            }
            if (temp == nums[i5] * 5) {
                i5++;
            }
        }
        return nums[n - 1];
    }
}
