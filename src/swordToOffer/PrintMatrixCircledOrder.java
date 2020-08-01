package swordToOffer;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrixCircledOrder {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) {
            return (ArrayList<Integer>) ans;
        }
        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            // 从左往右
            for (int c = c1; c <= c2; c++) {
                ans.add(matrix[r1][c]);
            }
            // 从上往下
            for (int r = r1 + 1; r <= r2; r++) {
                ans.add(matrix[r][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                // 从右往左
                for (int c = c2 - 1; c > c1; c--) {
                    ans.add(matrix[r2][c]);
                }
                // 从下到上
                for (int r = r2; r > r1; r--) {
                    ans.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return (ArrayList<Integer>) ans;
    }
}
