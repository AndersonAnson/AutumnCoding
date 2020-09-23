package test.oppo;

import java.util.ArrayList;

public class StringVertical {
    public static void main(String[] args) {
        String demoStr = "woppocom";
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i <= demoStr.length() - 2; i++) {
            for (int j = i + 1; j <= demoStr.length() - 1; j++) {
                String tempString = demoStr.substring(i, j + 1);
                if (isPalindrome(tempString)) {
                    res.add(tempString);
                }
            }
        }
        for (int i = 0; i < res.size(); i++) {
            if (i == res.size() - 1) {
                System.out.print(res.get(i));
            } else {
                System.out.print(res.get(i) + ",");
            }
        }
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
