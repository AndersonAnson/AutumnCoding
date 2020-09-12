package test.threesixzero;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flag = 1;
        while (sc.hasNext()) {
            String input = sc.next();
            if (flag == 1) {
                System.out.println();
                flag++;
            }

            int len = input.length();
            if (len < 8) {
                System.out.println("Irregular password");
            } else {
                boolean isDigit = false;
                boolean isCapital = false;
                boolean isSmall = false;
                boolean isSpecial = false;
                for (int i = 0; i < input.length(); i++) {
                    char tempChar = input.charAt(i);
                    if (tempChar >= 48 && tempChar <= 57) {
                        isDigit = true;
                    } else if (tempChar >= 65 && tempChar <= 90) {
                        isCapital = true;
                    } else if (tempChar >= 97 && tempChar <= 122) {
                        isSmall = true;
                    } else {
                        isSpecial = true;
                    }
                }
                if (isDigit && isCapital && isSmall && isSpecial) {
                    System.out.println("OK");
                } else {
                    System.out.println("Irregular password");
                }
            }
        }
    }
}
