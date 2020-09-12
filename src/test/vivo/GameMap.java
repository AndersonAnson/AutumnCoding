package test.vivo;

import java.util.Scanner;

public class GameMap {
    private static int ROW;
    private static int COL;
    private static int LEN;
    private static int ENDX;
    private static int ENDY;
    private static int RES = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int endX = sc.nextInt();
        int endY = sc.nextInt();
        char[][] map = new char[n][n];
        ROW = n;
        COL = n;
        ENDX = endX;
        ENDY = endY;
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
            }
        }
        dfs(map, startX, startY);
        if (RES == -1) {
            System.out.println(-1);
        } else {
            System.out.println(RES);
        }

    }

    public static void dfs(char[][] map, int row, int col) {
        if (row < 0 || col < 0 || row >= ROW || col >= COL || map[row][col] == '#' || map[row][col] == '@') {
            return;
        }
        map[row][col] = '#';
        if (row == ENDX && col == ENDY) {
            RES = LEN;
        }
        LEN++;
        dfs(map, row + 1, col);
        dfs(map, row - 1, col);
        dfs(map, row, col + 1);
        dfs(map, row, col - 1);
    }
}
