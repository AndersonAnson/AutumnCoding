package math;

public class IsHappy {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        } while (fast != slow);
        return fast == 1 ? true : false;
    }

    public int bitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int bit = n % 10;
            sum = sum + bit * bit;
            n = n / 10;
        }
        return sum;
    }
}
