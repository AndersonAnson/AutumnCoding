package swordToOffer;

public class Power {
    public double power(double base, int exponent) {
        if (base == 0.0) {
            return 0.0;
        }
//    前置结果设为1。0当exponent是0的时候就是1
        double result = 1.0;
//    获取指数的绝对值
        int e = Math.abs(exponent);
//    根据指数的大小 累计乘法
        for (int i = 1; i <= e; i++) {
            result = result * base;
        }
        if (exponent > 0) {
            return result;
        } else {
            return 1 / result;
        }
    }
}
