package test.sougou;

import java.util.Collections;
import java.util.LinkedList;

public class GetHouses {
    public int getHouses(int t, int[] xa) {
        // write code here
        if (xa == null || xa.length == 0) {
            return 1;
        }
        int pivot = 0;
        int width = 1;
        LinkedList<Double> linkedList = new LinkedList<>();
        for (; pivot <= xa.length - 2 && width <= xa.length - 1; pivot = pivot + 2, width = width + 2) {
            double left = xa[pivot] - (double) xa[width] / 2;
            double right = xa[pivot] + (double) xa[width] / 2;
            linkedList.addLast(left);
            linkedList.addLast(right);
        }
        Collections.sort(linkedList);
        int res = 2;
        linkedList.removeFirst();
        linkedList.removeLast();
        while (!linkedList.isEmpty()) {
            double leftIndex = linkedList.poll();
            double rightIndex = linkedList.poll();
            if (rightIndex - leftIndex == t) {
                res++;
            } else if (rightIndex - leftIndex > t) {
                res += 2;
            } else if (rightIndex - leftIndex < t) {

            }
        }
        return res;
    }
}
