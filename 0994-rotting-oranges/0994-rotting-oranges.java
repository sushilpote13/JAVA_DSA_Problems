class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // if the count of fresh is 0 then return 0;
        if (fresh == 0) {
            return 0;
        }

        // moves we can perform
        int[] dr = { 1, -1, 0, 0 };
        int[] dc = { 0, 0, 1, -1 };

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            time++;

            for (int i = 0; i < size; i++) {
                // {row , coll}
                int[] cell = q.remove();

                for (int j = 0; j < 4; j++) {
                    int nr = cell[0] + dr[j];
                    int nc = cell[1] + dc[j];

                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                        if (grid[nr][nc] == 1) {
                            // means this is fresh one make it rotton and add to the queue.
                            grid[nr][nc] = 2;
                            fresh--;
                            q.offer(new int[] { nr, nc });
                        }
                    }
                }
            }
        }
        if (fresh == 0) {
            return time - 1;
        }
        return -1;
    }
}