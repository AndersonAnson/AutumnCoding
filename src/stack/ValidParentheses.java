package stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        map.put('?', '?');
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        stack.push('?');
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (map.get(stack.pop()) != c) {
                return false;
            }
        }
        return stack.size() == 1;
    }

    public boolean isValidV2(String s){
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<Character>();
        stack.push('#');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char top = stack.pop();
                if (top != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 1;
    }
}
