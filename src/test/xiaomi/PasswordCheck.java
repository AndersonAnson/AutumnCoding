package test.xiaomi;

import java.util.Scanner;

public class PasswordCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String string = sc.next();
            if (string.length() < 8 || string.length() > 120) {
                System.out.println(1);
            } else {
                int aFlag = 0;
                int bFlag = 0;
                int cFlag = 0;
                int dFlag = 0;
                for (int i = 0; i < string.length(); i++) {
                    char c = string.charAt(i);
                    if (c >= 48 && c <= 57) {
                        aFlag++;
                    } else if (c >= 65 && c <= 90) {
                        bFlag++;
                    } else if (c >= 97 && c <= 122) {
                        cFlag++;
                    } else {
                        dFlag++;
                    }
                }
                if (aFlag > 0 && bFlag > 0 && cFlag > 0 && dFlag > 0) {
                    System.out.println(0);
                } else {
                    System.out.println(2);
                }
            }

        }
    }
}
