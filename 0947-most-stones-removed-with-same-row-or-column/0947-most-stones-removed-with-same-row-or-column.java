class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, stones, visited);
            }
        }

        return n - components;
    }

    void dfs(int i, int[][] stones, boolean[] visited) {
        visited[i] = true;

        for (int j = 0; j < stones.length; j++) {
            // Connect if same row or same column
            if (!visited[j] &&
                (stones[i][0] == stones[j][0] ||
                 stones[i][1] == stones[j][1])) {

                dfs(j, stones, visited);
            }
        }
    }
}