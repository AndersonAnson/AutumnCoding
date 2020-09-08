package test.xiaomi;

import java.util.Scanner;

public class WordSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        char[][] board = new char[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }
        String word = sc.next();
        boolean res = exist(board, word);
        System.out.println(res);
    }

    public static boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i, j, 0, word, visited, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int i, int j, int index, String word, boolean[][] visited, char[][] board) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (dfs(i + 1, j, index + 1, word, visited, board) || dfs(i - 1, j, index + 1, word, visited, board)
                || dfs(i, j + 1, index + 1, word, visited, board) || dfs(i, j - 1, index + 1, word, visited, board)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
