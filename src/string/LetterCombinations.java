package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        if (digits.length() != 0)
            backtrack("", digits, res, map);
        return res;
    }

    public void backtrack(String combination, String nextDigit, List<String> res, HashMap<Character, String> map) {
        if (nextDigit.length() == 0) {
            res.add(combination);
        } else {
            Character digit = nextDigit.charAt(0);
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = map.get(digit).substring(i, i + 1);
                backtrack(combination + letter, nextDigit.substring(1), res, map);
            }
        }
    }

    public List<String> letterCombinationsV2(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        String[] letter_map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            String letters = letter_map[digits.charAt(i) - '0'];
            int size = res.size();
            for (int j = 0; j < size; j++) {
                String temp = res.remove(0);
                for (int k = 0; k < letters.length(); k++) {
                    res.add(temp + letters.charAt(k));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23"));
    }
}
