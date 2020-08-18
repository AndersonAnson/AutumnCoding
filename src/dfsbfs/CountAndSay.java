package dfsbfs;

public class CountAndSay {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int cur = 1;
        if (n == 1) {
            return "1";
        }
        String str = countAndSay(n - 1);
        for (cur = 1; cur < str.length(); cur++) {
            if (str.charAt(left) != str.charAt(cur)) {// 如果碰到当前字符与前面紧邻的字符不等则更新此次结果
                int count = cur - left;
                sb.append(count).append(str.charAt(left));
                left = cur;
            }
        }
        if (left != cur) {// 防止最后一段数相等，如果不等说明p1到cur-1这段字符串是相等的
            sb.append(cur - left).append(str.charAt(left));
        }
        return sb.toString();
    }
}