package newCoder.tencent;

import java.util.Scanner;
import java.util.Stack;

public class StreetTallBuilding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        // 从前向后遍历，维持一个递减栈
        for (int i = 0; i < n; i++) {
            res[i] = res[i] + 1;
            res[i] = res[i] + stack.size();
            while (!stack.isEmpty() && stack.peek() <= heights[i]) {
                stack.pop();
            }
            stack.push(heights[i]);
        }
        stack.clear();
        // 从后向前遍历，同样维持递减栈
        for (int j = n - 1; j >= 0; j--) {
            res[j] = res[j] + stack.size();
            while (!stack.isEmpty() && stack.peek() <= heights[j]) {
                stack.pop();
            }
            stack.push(heights[j]);
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s = s.append(res[i] + " ");
        }
        System.out.println(s.deleteCharAt(s.length() - 1).toString());
    }
}
