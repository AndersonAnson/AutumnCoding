package swordToOffer;

public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 1;
        int preValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                count--;
                if (count == 0) {
                    preValue = array[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == preValue) {
                num++;
            }
        }
        return (num > array.length / 2) ? preValue : 0;
    }
}
