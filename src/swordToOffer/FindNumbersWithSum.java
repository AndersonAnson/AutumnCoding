package swordToOffer;

import java.util.ArrayList;

public class FindNumbersWithSum {
    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0, right = array.length - 1;
        if (array.length < 2) {
            return res;
        }
        while (left < right) {
            int current = array[left] + array[right];
            if (current < sum) {
                left++;
            } else if (current > sum) {
                right--;
            } else if (current == sum) {
                res.add(array[left]);
                res.add(array[right]);
                break;
            }
        }
        return res;
    }
}
