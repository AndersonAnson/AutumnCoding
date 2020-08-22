package test.scanner;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerV9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] strs = sc.nextLine().split(" ");
            Arrays.sort(strs);
            for (int i = 0; i < strs.length; i++) {
                System.out.print(strs[i]);
                if (i != strs.length - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}