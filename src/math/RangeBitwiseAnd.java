package math;

public class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == Integer.MAX_VALUE) {
            return m;
        }
        int res = m;
        for (int i = m + 1; i <= n; i++) {
            res = res & i;
            if (res == 0 || i == Integer.MAX_VALUE) {
                break;
            }
        }
        return res;
    }
}
