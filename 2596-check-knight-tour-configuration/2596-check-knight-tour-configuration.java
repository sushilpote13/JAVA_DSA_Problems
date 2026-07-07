class Solution {
    public boolean isVailed(int[][] grid, int row, int col, int isexpected) {
        // basecondition
        if (row < 0 || row >= grid.length || col < 0 || col >= grid.length || grid[row][col] != isexpected) {
            return false;
        }

        if (isexpected == (grid.length * grid.length) - 1) {
            return true;
        }
        // posible values 
        boolean ans1 = isVailed(grid, row + 2, col + 1, isexpected + 1);
        boolean ans2 = isVailed(grid, row + 2, col - 1, isexpected + 1);
        boolean ans3 = isVailed(grid, row + 1, col + 2, isexpected + 1);
        boolean ans4 = isVailed(grid, row + 1, col - 2, isexpected + 1);
        boolean ans5 = isVailed(grid, row - 1, col + 2, isexpected + 1);
        boolean ans6 = isVailed(grid, row - 1, col - 2, isexpected + 1);
        boolean ans7 = isVailed(grid, row - 2, col + 1, isexpected + 1);
        boolean ans8 = isVailed(grid, row - 2, col - 1, isexpected + 1);

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }

    public boolean checkValidGrid(int[][] grid) {
        return isVailed(grid, 0, 0, 0);
    }
}