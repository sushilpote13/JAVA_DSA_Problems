class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        // Main loop: find every new island
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Found an unvisited land cell
                if (grid[r][c] == '1' && !visited[r][c]) {
                    count++;
                    dfs(grid, visited, r, c);
                }
            }
        }

        return count;
    }


    public void dfs(char[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length) {
            return;
        }
        if (grid[r][c] == '0' || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        // Up
        dfs(grid, visited, r - 1, c);
        // Down
        dfs(grid, visited, r + 1, c);
        // Left
        dfs(grid, visited, r, c - 1);
        // Right
        dfs(grid, visited, r, c + 1);
    }
}