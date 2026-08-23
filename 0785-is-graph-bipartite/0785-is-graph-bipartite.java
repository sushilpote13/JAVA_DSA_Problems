class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        // 0 = not visited
        // 1 = group 1
        // -1 = group 2
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            // If this node is already colored,
            // it belongs to a component we already checked.
            if (color[i] != 0) {
                continue;
            }
            // Start DFS with color 1
            color[i] = 1;
            if (!dfs(i, graph, color)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int node, int[][] graph, int[] color) {
        // Visit every neighbor
        for (int neighbor : graph[node]) {
            // Neighbor is not visited
            if (color[neighbor] == 0) {
                // Give opposite color
                color[neighbor] = -color[node];
                // Continue DFS
                if (!dfs(neighbor, graph, color)) {
                    return false;
                }
            }
            // Neighbor already has the same color
            else if (color[neighbor] == color[node]) {
                return false;
            }
        }
        return true;
    }
}