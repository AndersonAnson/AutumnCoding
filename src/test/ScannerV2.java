package test;

import java.util.Scanner;

public class ScannerV2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int count = in.nextInt();
            for (int i = 0; i < count; i++) {
                long a = in.nextLong();
                long b = in.nextLong();
                System.out.println(a + b);
            }
        }

//        int count = in.nextInt();
//        for (int i = 0; i < count; i++) {
//            long a = in.nextLong();
//            long b = in.nextLong();
//            System.out.println(a + b);
//        }
    }
}
