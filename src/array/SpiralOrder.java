package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || (matrix.length == 0 || matrix[0].length == 0)) {
            return res;
        }
        int down = matrix.length - 1, right = matrix[0].length - 1;
        int up = 0, left = 0;
        while (true) {
            // left to right
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            if (++up > down)
                break;
            // top to bottom
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            // right to left
            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            if (--down < up) {
                break;
            }
            // bottom to top
            for (int i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }

}
