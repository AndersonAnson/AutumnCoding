package swordToOffer;

import java.util.TreeSet;

public class IsContinuous {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length < 5 || numbers.length > 5) {
            return false;
        }
        int num = 0;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                num++;
            } else {
                set.add(numbers[i]);
            }
        }
        if ((num + set.size() != 5)) {
            return false;
        }
        if (set.last() - set.first() < 5) {
            return true;
        }
        return false;
    }
}
