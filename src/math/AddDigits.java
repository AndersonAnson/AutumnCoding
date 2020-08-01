package math;

public class AddDigits {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    public int addDigitsV2(int num) {
        while (num >= 10) {
            num = num / 10 + num % 10;
        }
        return num;
    }
}
