package math;

public class Divide {
    public int divide(int dividend, int divisor) {
//        将除法转化为减法，循环相减，如果被除数和除数都是正数
//        由于被除数和除数可能异号，加一个标志位进行判断
//        采用二分法的思想，dividend每次减去2^n个divisor（尽可能多），同时reslut每次加2^n
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean k = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        int result = 0;
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        while (dividend <= divisor) {
            int temp = divisor;
            int c = 1;
            while (dividend - temp <= temp) {
                temp = temp << 1;
                c = c << 1;
            }
            dividend = dividend - temp;
            result = result + c;
        }
        return k ? result : -result;
    }
}
