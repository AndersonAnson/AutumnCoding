package newCoder.tencent;

import java.util.Collections;
import java.util.Scanner;

public class Compression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(decode(str));
    }

    public static String decode(String string) {
        while (string.contains("]")) {
            int right = string.indexOf("]");
            int left = string.lastIndexOf("[", right);
            String repeatStr = string.substring(left + 1, right);
            String[] split = repeatStr.split("\\|");
            string = string.replace("[" + repeatStr + "]", String.join("", Collections.nCopies(Integer.valueOf(split[0]), split[1])));
        }
        return string;
    }
}
