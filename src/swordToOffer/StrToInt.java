package swordToOffer;

public class StrToInt {
    public int strToInt(String str) {
        if (str == null || "".equals(str.trim()))
            return 0;
        str = str.trim();
        char[] arr = str.toCharArray();
        int i = 0, flag = 1, res = 0;
        if (arr[i] == '-') {
            flag = -1;
        }
        if (arr[i] == '+' || arr[i] == '-') {
            i++;
        }
        while (i < arr.length) {
            if (isNumber(arr[i])) {
                int cur = arr[i] - '0';
                if (flag == 1 && (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && cur > 7)) {
                    return 0;
                }
                if (flag == -1 && (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && cur > 8)) {
                    return 0;
                }
                res = res * 10 + cur;
                i++;
            } else {
                return 0;
            }
        }
        return res * flag;
    }

    public boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
