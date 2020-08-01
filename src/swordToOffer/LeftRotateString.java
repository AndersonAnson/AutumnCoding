package swordToOffer;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeftRotateString {
    public static String leftRotateString(String str, int n) {
        String res = "";
        if (str.length() == 0 || str == null) {
            return res;
        }
        if (n == 0) {
            return str;
        }
        int len = str.length();
        int index = n % len;
        // 定义一个队列
        Queue<Character> q = new ArrayDeque<>();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            q.offer(arr[i]);
        }
        int flag = 1;
        while (flag <= index) {
            char temp = q.poll();
            q.offer(temp);
            flag++;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = q.poll();
            res = res + arr[i];
        }
        return res;
    }
}
