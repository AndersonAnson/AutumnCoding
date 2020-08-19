package string;

import java.util.*;

public class ReverseWords {
    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        int right = s.length() - 1, left = right;
        StringBuilder sb = new StringBuilder();
        while (left >= 0) {
            // 搜索首个空格
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            // 添加单词
            sb.append(s.substring(left + 1, right + 1) + " ");
            // 跳过单词间空格
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            right = left;
        }
        return sb.toString().trim();
    }

    public String reverseWordsV2(String s) {
        String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if (strs[i].equals("")) continue; // 遇到空单词则跳过
            res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
        }
        return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }

    public String reverseWordsV3(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (word.length() != 0 && (c == ' ')) {
                deque.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            left++;
        }
        deque.offerFirst(word.toString());
        return String.join(" ", deque);
    }
}
