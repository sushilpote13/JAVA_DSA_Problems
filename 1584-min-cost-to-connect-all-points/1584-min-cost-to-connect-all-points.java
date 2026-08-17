class Solution {

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        // Initially, distance of every vertex is infinity
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // Start Prim's algorithm from point 0
        dist[0] = 0;

        int totalCost = 0;

        for (int count = 0; count < n; count++) {

            // Find the unvisited vertex with minimum distance
            int u = -1;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }

            // Add this vertex to MST
            visited[u] = true;
            totalCost += dist[u];

            // Update distances of remaining vertices
            for (int v = 0; v < n; v++) {

                if (!visited[v]) {

                    int distance =
                        Math.abs(points[u][0] - points[v][0])
                        + Math.abs(points[u][1] - points[v][1]);

                    if (distance < dist[v]) {
                        dist[v] = distance;
                    }
                }
            }
        }

        return totalCost;
    }
}