import java.util.*;

class Solution {

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        // Start from point 0
        dist[0] = 0;

        int totalCost = 0;

        for (int i = 0; i < n; i++) {

            // Find minimum cost unvisited vertex
            int u = -1;

            for (int j = 0; j < n; j++) {

                if (!visited[j] &&
                    (u == -1 || dist[j] < dist[u])) {

                    u = j;
                }
            }

            // Add vertex to MST
            visited[u] = true;
            totalCost += dist[u];

            // Update all unvisited vertices
            for (int v = 0; v < n; v++) {

                if (!visited[v]) {

                    int wt = Math.abs(points[u][0] - points[v][0])
                           + Math.abs(points[u][1] - points[v][1]);

                    if (wt < dist[v]) {
                        dist[v] = wt;
                    }
                }
            }
        }

        return totalCost;
    }
}