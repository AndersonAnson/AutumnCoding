package test.amazon;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution2 {
    public static void main(String args[]) {
        // Write your code here
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] nums = new int[N];
        int start = s.nextInt();
        int end = s.nextInt();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (N == 0) {
            System.out.println(res);
        } else {
            int startIndex = (int) Math.pow(2, start - 1) - 1;
            int endIndex = (int) Math.pow(2, end - 1) - 1;
            int distance = (int) Math.pow(2, start - 1);
            ArrayList<Integer> line = new ArrayList<>();
            int i = startIndex;
            while (i <= endIndex) {
                for (i = startIndex; i <= startIndex + distance - 1; i++) {
                    if (nums[i] != -1) {
                        line.add(nums[i]);
                    }

                }
                res.add(line);
                startIndex = i + 1;
                line.clear();
            }
            for (i = 0; i < res.size(); i++) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = 0; j < temp.size(); j++) {
                    System.out.println(temp.get(j));
                }
                System.out.println();
            }
        }
    }
}
