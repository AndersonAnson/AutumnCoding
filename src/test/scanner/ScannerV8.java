package test.scanner;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerV8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int len = Integer.parseInt(in.nextLine());
            String[] strs = in.nextLine().split(" ");
            Arrays.sort(strs);
            for (int i = 0; i < len; i++) {
                System.out.println(strs[i] + " ");
            }
        }
    }
}
