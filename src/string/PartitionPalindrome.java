package string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PartitionPalindrome {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Deque<String> arrayDeque = new ArrayDeque<>();
        backtrack(s, 0, len, arrayDeque, res);
        return res;
    }

    private void backtrack(String s, int start, int len, Deque<String> path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            if (!checkPalindrome(s, start, i)) {
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            backtrack(s, i + 1, len, path, res);
            path.removeLast();
        }
    }

    private boolean checkPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public List<List<String>> partitionV2(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        boolean[][] dp = new boolean[len][len];
        // 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
        for (int right = 0; right < len; right++) {
            // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2) || dp[left + 1][right - 1]) {
                    dp[left][right] = true;
                }
            }
        }
        Deque<String> arrayDeque = new ArrayDeque<>();
        backtrackV2(s, 0, len, dp, arrayDeque, res);
        return res;
    }

    private void backtrackV2(String s, int start, int len, boolean[][] dp, Deque<String> path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            if (!dp[start][i]) {
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            backtrackV2(s, i + 1, len, dp, path, res);
            path.removeLast();
        }
    }
}
