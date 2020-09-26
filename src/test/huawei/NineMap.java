package test.huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class NineMap {
    public static int maxRes = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        HashMap<Integer, Integer> obstacleMap = new HashMap<>();
        boolean[][] obstacleMap = new boolean[9][9];
//        Arrays.fill(obstacleMap, false);
//        Arrays.fill(obstacleMap[0], false);
        int M = sc.nextInt();
        for (int i = 1; i <= M; i++) {
            int P = sc.nextInt();
            int Q = sc.nextInt();
            obstacleMap[P - 1][Q - 1] = true;
        }
        int N = sc.nextInt();

        int[][] map = new int[3][3];
        int start = 1;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = start;
                start++;
            }
        }
        System.out.println(map[0][1]);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                dfs(map, obstacleMap, map[row][col], row, col, N);
            }
        }
    }

    public static void dfs(int[][] map, boolean[][] obstacleMap, int tempNum, int row, int col, int N) {
        tempNum = tempNum * 10 + map[row][col];
        if (N == 0) {
            maxRes = Math.max(tempNum, maxRes);
            return;
        }
        boolean isOrNot = obstacleMap[row][col];

    }
}
