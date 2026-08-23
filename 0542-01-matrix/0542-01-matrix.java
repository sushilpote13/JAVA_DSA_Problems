class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = 0;
        int col = 0;
        while (row < mat.length) {
            if (mat[row][col] == 1) {
                mat[row][col] = Integer.MAX_VALUE / 2;
            }
            col++;
            if (col == mat[0].length) {
                col = 0;
                row++;
            }
        }
        row = 0;
        col = 0;
        while (row < mat.length) {
            if (mat[row][col] != 0) {
                if (col - 1 >= 0) {
                    mat[row][col] = Math.min(mat[row][col],
                            mat[row][col - 1] + 1);
                }
                if (row - 1 >= 0) {
                    mat[row][col] = Math.min(mat[row][col],
                            mat[row - 1][col] + 1);
                }
            }
            col++;
            if (col == mat[0].length) {
                col = 0;
                row++;
            }
        }
        row = mat.length - 1;
        col = mat[0].length - 1;
        while (row >= 0) {
            if (mat[row][col] != 0) {
                if (col + 1 < mat[0].length) {
                    mat[row][col] = Math.min(mat[row][col],
                            mat[row][col + 1] + 1);
                }
                if (row + 1 < mat.length) {
                    mat[row][col] = Math.min(mat[row][col],
                            mat[row + 1][col] + 1);
                }
            }
            col--;
            if (col < 0) {
                col = mat[0].length - 1;
                row--;
            }
        }
        return mat;
    }
}