package swordToOffer;

public class MovingCount {
    // 统计能够走到的次数
    public int count = 0;

    // 判断坐标是否符合要求
    public boolean isValid(int row, int col, int threshold) {
        int sum = 0;
        while (row > 0) {
            sum += row % 10;
            row = row / 10;
        }
        while (col > 0) {
            sum += col % 10;
            col = col / 10;
        }
        if (sum > threshold)
            return false;
        else
            return true;
    }

    public void help(int i, int j, int threshold, int rows, int cols, int[][] flag) {
        if (i < 0 || i >= rows || j < 0 || j >= cols)
            return;// 如果坐标不符合则不计数
        if (flag[i][j] == 1)
            return;// 如果曾经被访问过则不计数
        if (!isValid(i, j, threshold)) {
            flag[i][j] = 1;// 如果不满足坐标有效性，则不计数并且标记是访问的
            return;
        }
        // 无论是广度优先遍历还是深度优先遍历，我们一定要知道的时候遍历一定会有终止条件也就是要能够停止，
        // 不然程序就会陷入死循环，这个一定是我们做此类题目必须要注意的地方
        flag[i][j] = 1;
        count++;
        help(i - 1, j, threshold, rows, cols, flag);// 遍历上下左右节点
        help(i + 1, j, threshold, rows, cols, flag);
        help(i, j - 1, threshold, rows, cols, flag);
        help(i, j + 1, threshold, rows, cols, flag);
    }

    public int movingCount(int threshold, int rows, int cols) {
        int[][] flag = new int[rows][cols];
        help(0, 0, threshold, rows, cols, flag);
        return count;
    }
}
