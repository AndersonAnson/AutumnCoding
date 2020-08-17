package collections;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int L = 9;
        boolean[][] row = new boolean[L][L];
        boolean[][] col = new boolean[L][L];
        boolean[][] box = new boolean[L][L];
        for (int r = 0; r < L; r++) {
            for (int c = 0; c < L; c++) {
                if (board[r][c] != '.') {
                    int value = board[r][c] - '1';
                    int boxIndex = r / 3 * 3 + c / 3;
                    if (row[r][value] || col[c][value] || box[boxIndex][value]) {
                        return false;
                    }
                    row[r][value] = true;
                    col[c][value] = true;
                    box[boxIndex][value] = true;
                }
            }
        }
        return true;
    }
}
