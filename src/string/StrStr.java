package string;

public class StrStr {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        int res = -1;
        if (haystack.length() == 0) {
            return -1;
        }
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len1 < len2) {
            return res;
        }
        int left = 0, right = len2 - 1;
        while (right < len1) {
            String sub = haystack.substring(left, right + 1);
            if (sub.equals(needle)) {
                res = left;
                break;
            }
            left++;
            right++;
        }
        return res;
    }
}
