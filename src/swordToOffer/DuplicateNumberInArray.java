package swordToOffer;

import java.util.HashSet;

public class DuplicateNumberInArray {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length == 0) {
            return false;
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (hs.contains(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            } else {
                hs.add(numbers[i]);
            }

        }
        return false;
    }
}
