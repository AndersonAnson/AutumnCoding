package math;

import java.util.Stack;

public class CountAndSay {
    Stack<Character> stack = new Stack<Character>();

    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int cur = 1;
        if (n == 1) {
            return "1";
        }
        String str = countAndSay(n - 1);
        for (cur = 1; cur < sb.length(); ) {
//            如果一样的话
            if (str.charAt(left) != str.charAt(1)) {
                int count = cur - 1;
                sb.append(count).append(str.charAt(left));
                left = cur;
            }
            cur++;
        }
        if (left != cur) {
            sb.append(cur - left).append(str.charAt(left));
        }
        return sb.toString();
    }
}
