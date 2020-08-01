package swordToOffer;

public class FindGreatestSumOfSubArray {
    public int findGreatestSumOfSubArray(int[] array) {
//        从头开始遍历 如果得到的答案大于0就保存 如果得到的答案小于0就扔掉
        int maxVal = Integer.MIN_VALUE;
        maxVal = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > 0) {
                array[i] = array[i - 1] + array[i];
            }
            maxVal = Math.max(maxVal, array[i]);
        }
        return maxVal;
    }
}
