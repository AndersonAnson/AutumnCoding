package swordToOffer;

import java.util.ArrayList;

public class MaxInWindows {
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> maxList = new ArrayList<>();
        if (size == 0) {
            return maxList;
        }
        int windowLen = size - 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= num.length - 1 - windowLen; i++) {
            for (int j = i; j <= i + windowLen; j++) {
                max = Math.max(max, num[j]);
            }
            maxList.add(max);
            max = Integer.MIN_VALUE;
        }
        return maxList;
    }
}
