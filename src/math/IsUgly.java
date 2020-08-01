package math;

public class IsUgly {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        int[] factor = new int[]{2, 3, 5};
        for (int i : factor) {
            while (num % i == 0) {
                num = num / i;
            }
        }
        return num == 1;
    }
}
