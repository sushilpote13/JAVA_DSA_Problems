class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];

        int groups = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                groups++;
                dfs(i, stones, visited);
            }
        }

        return n - groups;
    }

    private void dfs(int i, int[][] stones, boolean[] visited) {
        visited[i] = true;

        for (int j = 0; j < stones.length; j++) {
            if (!visited[j] &&
                (stones[i][0] == stones[j][0] ||
                 stones[i][1] == stones[j][1])) {

                dfs(j, stones, visited);
            }
        }
    }
}