package swordToOffer;

import java.util.HashMap;

public class CharStreamWithNoReplication {
    String str = "";
    HashMap<Character, Integer> map = new HashMap<>();

    // Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
        str = str + ch;
    }

    // return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char temp = '#';
        for (int i = 0; i < str.length(); i++) {
            temp = str.charAt(i);
            int fre = map.get(temp);
            if (fre == 1) {
                return temp;
            }
        }
        return '#';
    }
}
