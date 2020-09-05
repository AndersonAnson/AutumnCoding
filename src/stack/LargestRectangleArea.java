package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        int[] left_i = new int[n];
        int[] right_i = new int[n];
        left_i[0] = -1;
        right_i[n - 1] = n;
        for (int i = 1; i < n; i++) {
            int temp = i - 1;
            while (temp >= 0 && heights[temp] >= heights[i]) {
                temp = left_i[temp];
            }
            left_i[i] = temp;
        }
        for (int i = n - 2; i >= 0; i--) {
            int temp = i + 1;
            while (temp < n && heights[temp] >= heights[i]) {
                temp = right_i[temp];
            }
            right_i[i] = temp;
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (right_i[i] - left_i[i] - 1) * heights[i]);
        }
        return res;
    }

    public int largestRectangleAreaV2(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] newHeights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) {
            newHeights[i] = heights[i - 1];
        }
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                int cur = stack.poll();
                res = Math.max(res, (i - stack.peek() - 1) * newHeights[cur]);
            }
            stack.push(i);
        }
        return res;
    }
}
