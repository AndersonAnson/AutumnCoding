package string;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        char[] arr = s.toCharArray();
        int right = arr.length - 1;
        while (right >= 0 && arr[right] == ' ') {
            right--;
        }
        if (right == -1)
            return 0;
        for (; right >= 0; right--) {
            if (arr[right] == ' ') {
                break;
            } else {
                maxLen++;
            }
        }
        return maxLen;
    }

    public int lengthOfLastWordV2(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) continue;
                break;
            }
            count++;
        }
        return count;
    }
}
