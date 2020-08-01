package swordToOffer;

import java.util.LinkedList;

public class ReOrderArray {
    public void reOrderArray(int[] array) {
        LinkedList<Integer> odd = new LinkedList<Integer>();
        LinkedList<Integer> even = new LinkedList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                even.add(array[i]);
            } else {
                odd.add(array[i]);
            }
        }
        int i = 0;
        while (true) {
            while (odd.size() > 0) {
                array[i] = odd.pop();
                i++;
            }
            while (even.size() > 0) {
                array[i] = even.pop();
                i++;
            }
            break;
        }
    }
}
