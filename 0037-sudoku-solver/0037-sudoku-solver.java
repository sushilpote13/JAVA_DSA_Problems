class Solution {
    public static boolean isSafe(char[][] board, int row, int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == (char) (number + '0')) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == (char) (number + '0')) {
                return false;
            }
        }
        row = (row / 3) * 3;
        col = (col / 3) * 3;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] == (char) (number + '0')) {
                    return false;

                }
            }
        }
        return true;
    }

    public static boolean sudoko(char[][] board, int row, int col) {
        // base condition
        if (row == 9) {
            return true;
        }
        if (board[row][col] != '.') {
            if (col == 8) {
                return sudoko(board, row + 1, 0);
            } else {
                return sudoko(board, row, col + 1);
            }
        }
        for (int i = 0; i < 9; i++) {
            if (isSafe(board, row, col, i + 1)) {
                board[row][col] = (char) (i + 1 + '0');
                // recursion
                int nextrow = row;
                int nextcol = col + 1;
                if (nextcol == 9) {
                    nextrow++;
                    nextcol = 0;
                }
                if (sudoko(board, nextrow, nextcol)) {
                    return true;
                }
                // backtracking
                board[row][col] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        sudoko(board, 0, 0);
    }
}