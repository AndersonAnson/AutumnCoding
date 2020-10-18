package test.huawei;

import java.util.LinkedList;

public class ProblemTwo {
    public static int[][] minMatrix;
    public static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void repairMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        minMatrix = matrix;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    bfs(i, j, matrix, 0);
                }
            }
        }
    }

    public static void bfs(int row, int col, int[][] matrix, int flag) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(matrix[row][col]);
        while (!queue.isEmpty()) {
            int tempPoint = queue.poll();
            if (tempPoint == -1) {
                continue;
            } else if (tempPoint == 0) {
                continue;
            } else {
                flag = flag + 1;
                int distance = minMatrix[row][col];
                if (distance > flag) {
                    matrix[row][col] = flag;
                }
                if (row >= 0 && row <= matrix.length && col >= 0 && col <= matrix[0].length) {
                    matrix[row][col] = -1;
                    for (int i = 0; i < direction.length; i++) {
                        bfs(row + direction[i][0], col + direction[i][1], matrix, flag);
                    }
                }
            }
        }
    }
}
