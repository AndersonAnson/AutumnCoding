package general;

public class GCD {
    private static int gcd(int a, int b) {
        int rem = 0;
        while (b != 0) {
            rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = 3;
        int b = 2;
        int gcd = gcd(a, b);
        int lcm = (a * b) / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }
}
