package test.chinaTel;

public class ABCDValue {
    public static void main(String[] args) {
        int a, b, c, d;
        for (a = 0; a < 10; a++) {
            for (b = 0; b < 10; b++) {
                for (c = 0; c < 10; c++) {
                    for (d = 0; d < 10; d++) {
                        if (1001 * a + 1100 * b + 110 * c + 11 * d == 8888) {
                            System.out.printf("%d %d %d %d", a, b, c, d);
                            System.out.println();
                        }
                    }
                }
            }
        }
    }
}
