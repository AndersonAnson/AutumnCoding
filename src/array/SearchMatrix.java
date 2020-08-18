package array;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        int left = 0, right = row * col - 1;
        int pivotIndex, pivotElement;
        while (left <= right) {
            pivotIndex = left + (right - left) / 2;
            pivotElement = matrix[pivotIndex / col][pivotIndex % col];
            if (target == pivotElement) {
                return true;
            } else if (target < pivotElement) {
                right = pivotIndex - 1;
            } else if (target > pivotElement) {
                left = pivotIndex + 1;
            }
        }
        return false;
    }
}
