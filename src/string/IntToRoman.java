package string;

import java.util.HashMap;

public class IntToRoman {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};  // °¢À­²®Êı×Ö
        int index = 0;
        while (num > 0) {
            int count = num / arab[index];
            for (int i = 0; i < count; i++) {
                res.append(roman[index]);
            }
            num = num % arab[index];
            index++;
        }
        return res.toString();
    }
}
