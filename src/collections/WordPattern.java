package collections;

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> hashMap = new HashMap<>();
        String[] arr = str.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            Character tempChar = pattern.charAt(i);
            if (!hashMap.containsKey(tempChar)) {
                if (hashMap.containsValue(arr[i])) {
                    return false;
                }
                hashMap.put(tempChar, arr[i]);
            } else {
                String wantString = hashMap.get(tempChar);
                if (!wantString.equals(arr[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
