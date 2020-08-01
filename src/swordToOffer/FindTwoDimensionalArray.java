package swordToOffer;

public class FindTwoDimensionalArray {
    public boolean findTwoDimensionalArray(int target, int[][] array) {
        int rows = array.length;
        if (rows == 0) {
            return false;
        }
        int cols = array[0].length;
        if (cols == 0) {
            return false;
        }
//		开始循环
//		从左下开始
        int i = rows - 1;
        int j = 0;

        while (i >= 0 && j <= cols - 1) {
            if (target == array[i][j]) {
                return true;
            } else if (target > array[i][j]) {
//				去掉这一列
                j = j + 1;
            } else {
//				去掉这一行
                i = i - 1;
            }
        }
        return false;
    }
}
