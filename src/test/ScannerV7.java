package test;

import java.util.Scanner;

public class ScannerV7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] nums = in.nextLine().split(" ");
            int sum = 0;
            for (String string : nums) {
                sum = sum + Integer.valueOf(string);
            }
            System.out.println(sum);
        }
    }
}
