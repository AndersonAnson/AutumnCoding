package string;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if (strs.length == 0) {
            return res;
        }
        for (int i = 0; i < strs[0].length(); i++) {
            String tempCommonPrefix = strs[0].substring(0, i + 1);
            for (int j = 1; j < strs.length; j++) {
                if (i + 1 <= strs[j].length()) {
                    if (!tempCommonPrefix.equals(strs[j].substring(0, i + 1))) {
                        return res;
                    }
                } else {
                    return res;
                }
            }
            res = tempCommonPrefix;
        }
        return res;
    }
}
