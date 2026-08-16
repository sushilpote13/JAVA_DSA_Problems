class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;

        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            // find minimum unvisted array
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }

            // vist the point
            visited[u] = true;
            totalCost += dist[u];

            // update all the unvisted vertices 
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int wt = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    if (wt < dist[v]) {
                        dist[v] = wt;
                    }
                }
            }
        }
        return totalCost;
    }
}