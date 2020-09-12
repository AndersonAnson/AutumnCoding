package test.vivo;

import java.util.Scanner;

public class DeleteAndPlaindrome {
    public static boolean isPlaindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder(s);
        if (s == null && s.length() <= 2) {
            System.out.println("false");
        } else {
            for (int i = 0; i < s.length(); i++) {
                char temp = sb.charAt(i);
                sb.deleteCharAt(i);
                if (isPlaindrome(sb.toString())) {
                    break;
                } else {
                    sb.insert(i, temp);
                }
            }
            if (sb.toString().length() == s.length()) {
                System.out.println("false");
            } else {
                System.out.println(sb.toString());
            }
        }
    }
}
