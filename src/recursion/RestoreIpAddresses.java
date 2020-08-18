package recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len < 4 || len > 12) {
            return res;
        }
        Deque<String> path = new ArrayDeque<>(4);
        int splitTimes = 0;
        dfs(s, len, splitTimes, 0, path, res);
        return res;
    }

    private void dfs(String s, int len, int splitTimes, int begin, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (splitTimes == 4) {
                res.add(String.join(".", path));
            }
            return;
        }
        // 看到剩下的不够了，就退出（剪枝），len - begin 表示剩余的还未分割的字符串的位数
        if (len - begin < (4 - splitTimes) || len - begin > 3 * (4 - splitTimes)) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (begin + i >= len) {
                break;
            }
            if (judgeIfIpSegment(s, begin, begin + i)) {
                String currentIpSegment = s.substring(begin, begin + i + 1);
                path.addLast(String.valueOf(currentIpSegment));
                dfs(s, len, splitTimes + 1, begin + i + 1, path, res);
                path.removeLast();
            }
        }
    }

    //判断 s 的子区间 [left, right] 是否能够成为一个 ip 段
    private boolean judgeIfIpSegment(String s, int begin, int end) {
        int len = end - begin + 1;
        if (len > 1 && s.charAt(begin) == '0') {
            return false;
        }
        String segment = s.substring(begin, end + 1);
        Integer segmentToInt = Integer.valueOf(segment);
        return segmentToInt >= 0 && segmentToInt <= 255;
    }
}
