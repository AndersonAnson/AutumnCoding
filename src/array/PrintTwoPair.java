package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PrintTwoPair {
    public HashSet<List<Integer>> printTwoPair(int[] arr, int k) {
        HashSet<List<Integer>> res = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        if (arr == null || arr.length < 2) {
            return res;
        }
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < k) {
                left++;
            } else if (arr[left] + arr[right] > k) {
                right--;
            } else {
                list.add(arr[left]);
                list.add(arr[right]);
                res.add(list);
                list.clear();
                left++;
                right--;
            }
        }
        return res;
    }
}
