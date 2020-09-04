package test.pdd;

import java.util.LinkedList;
import java.util.Scanner;

public class BFS {
    public static boolean inArea(int x, int y, int ROWS, int COLS) {
        return x >= 0 && x <= ROWS && y >= 0 && y <= COLS;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        boolean[][] marked = new boolean[N][M];
        int maxArea = 0;
        LinkedList<Integer> maxList = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxArea = 0;
                if (!marked[i][j] && matrix[i][j] == 1) {
                    maxArea++;
                    LinkedList<Integer> linkedList = new LinkedList<>();
                    linkedList.addLast(i * M + j);
                    marked[i][j] = true;
                    while (!linkedList.isEmpty()) {
                        int cur = linkedList.removeFirst();
                        int curX = cur / M;
                        int curY = cur % M;
                        for (int k = 0; k < 4; k++) {
                            int newX = curX + directions[k][0];
                            int newY = curY + directions[k][1];
                            if (inArea(newX, newY, N, M) && matrix[newX][newY] == 1 && !marked[newX][newY]) {
                                linkedList.addLast(newX * M + newY);
                                marked[newX][newY] = true;
                            }
                        }
                    }
                }
                maxList.addLast(maxArea);
            }
        }
        boolean move = false;
        boolean[][] marked2 = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxArea = 0;
                if (!marked2[i][j] && matrix[i][j] == 0 && move == false) {
                    move = true;
                    maxArea++;
                    LinkedList<Integer> linkedList = new LinkedList<>();
                    linkedList.addLast(i * M + j);
                    marked[i][j] = true;
                    while (!linkedList.isEmpty()) {
                        int cur = linkedList.removeFirst();
                        int curX = cur / M;
                        int curY = cur % M;
                        for (int k = 0; k < 4; k++) {
                            int newX = curX + directions[k][0];
                            int newY = curY + directions[k][1];
                            if (inArea(newX, newY, N, M) && matrix[newX][newY] == 1 && !marked2[newX][newY]) {
                                linkedList.addLast(newX * M + newY);
                                marked2[newX][newY] = true;
                            }
                        }
                    }
                }
                if (!marked2[i][j] && matrix[i][j] == 1) {
                    maxArea++;
                    LinkedList<Integer> linkedList = new LinkedList<>();
                    linkedList.addLast(i * M + j);
                    marked[i][j] = true;
                    while (!linkedList.isEmpty()) {
                        int cur = linkedList.removeFirst();
                        int curX = cur / M;
                        int curY = cur % M;
                        for (int k = 0; k < 4; k++) {
                            int newX = curX + directions[k][0];
                            int newY = curY + directions[k][1];
                            if (inArea(newX, newY, N, M) && matrix[newX][newY] == 1 && !marked2[newX][newY]) {
                                linkedList.addLast(newX * M + newY);
                                marked2[newX][newY] = true;
                            }
                        }
                    }
                }
                maxList.addLast(maxArea);
            }
        }
        int res = 0;
        for (Integer i : maxList) {
            res = Math.max(res, i);
        }
        System.out.println(res);
    }
}
