package array;

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int[][] matrix = new int[n][n];
        int num = 1, target = n * n;
        while (num <= target) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num;
                num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num;
                num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num;
                num++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num;
                num++;
            }
            left++;
        }
        return matrix;
    }
}
