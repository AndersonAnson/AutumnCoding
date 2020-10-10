package test.huawei;

import java.util.*;

public class MatrixSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int sum = m * n;
        List<Integer> arr = new ArrayList<>(sum);
        for (int i = 0; i < sum; i++) {
            arr.add(sc.nextInt());
        }
        Collections.sort(arr);
        int[][] res = returnMatrix(arr, m, n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] returnMatrix(List<Integer> arr, int m, int n) {
        int[][] matrix = new int[m][n];
        int left = 0, right = n - 1;
        int top = 0, bottom = m - 1;
        int i = 0;
        while (i <= arr.size() - 1) {
            for (int k = left; k <= right; k++) {
                int temp = arr.get(i);
                matrix[top][k] = temp;
                i++;
            }
            top++;
            for (int k = top; k <= bottom; k++) {
                int temp = arr.get(i);
                matrix[k][right] = temp;
                i++;
            }
            right--;
            for (int k = right; k >= left; k--) {
                int temp = arr.get(i);
                matrix[bottom][k] = temp;
                i++;
            }
            bottom--;
            for (int k = bottom; k >= top; k--) {
                int temp = arr.get(i);
                matrix[k][left] = temp;
                i++;
            }
            left++;
        }
        return matrix;
    }
}
