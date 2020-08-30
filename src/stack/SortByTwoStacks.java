package stack;

import java.util.Stack;

public class SortByTwoStacks {
    public void sortByTwoStacks(int[] nums) {
        Stack<Integer> mainA = new Stack<>();
        Stack<Integer> helperB = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            mainA.push(nums[i]);
        }
        while (!mainA.isEmpty()) {
            if (helperB.isEmpty()) {
                helperB.push(mainA.pop());
            } else {
                int cur = mainA.pop();
                if (cur > helperB.peek()) {
                    while (!helperB.isEmpty()) {
                        mainA.push(helperB.pop());
                    }
                    helperB.push(cur);
                } else {
                    helperB.push(cur);
                }
            }
        }
//        遍历helperB即可得到从小到大排序
        while (!helperB.isEmpty()) {
            System.out.println(helperB.pop());
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 1, 5, 6, 6, 9, 11};
        new SortByTwoStacks().sortByTwoStacks(nums);
    }
}
