package stack;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        if (path.length() == 0) {
            return sb.toString();
        }
        Stack<String> stack = new Stack<>();
        String[] splitPath = path.split("/");
        for (int i = 0; i < splitPath.length; i++) {
            if (!stack.isEmpty() && splitPath[i].equals("..")) {
                stack.pop();
            } else if (!splitPath[i].equals("") && !splitPath[i].equals(".") && splitPath[i].equals("..")) {
                stack.push(splitPath[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        for (int i = 0; i < stack.size(); i++) {
            String temp = stack.get(i);
            sb.append("/" + temp);
        }
        return sb.toString();
    }
}
