package test.scanner;

import java.util.Scanner;

public class ScannerV5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        while (in.hasNext()) {
            int num = in.nextInt();
            int[] arr = new int[num];
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextInt();
                sum = sum + arr[i];
            }
            System.out.println(sum);
        }
    }
}
