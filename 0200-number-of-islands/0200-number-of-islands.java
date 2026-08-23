class Solution {

    int[][] directions = {
        {-1, 0},   // up
        {1, 0},    // down
        {0, -1},   // left
        {0, 1}     // right
    };

    public int numIslands(char[][] grid) {

        int count = 0;

        for (int r = 0; r < grid.length; r++) {

            for (int c = 0; c < grid[0].length; c++) {

                if (grid[r][c] == '1') {

                    count++;

                    dfs(grid, r, c);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int r, int c) {

        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length ||
            grid[r][c] == '0') {

            return;
        }

        // Mark visited
        grid[r][c] = '0';

        // Visit all 4 neighbors
        for (int[] dir : directions) {

            int newRow = r + dir[0];
            int newCol = c + dir[1];

            dfs(grid, newRow, newCol);
        }
    }
}