package string;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
//            记录每个字母出现的次数
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
