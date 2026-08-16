import java.util.*;

class Solution {
    public class Edges {
        int src;
        int dest;
        int wt;

        public Edges(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // Step 1: Build Graph
        ArrayList<Edges>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // fill the Graph
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int wt = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                graph[i].add(new Edges(i, j, wt));
                graph[j].add(new Edges(j, i, wt));
            }
        }

        // Step 2: Prim's Algorithm
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        // Start from node 0
        dist[0] = 0;

        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            // Find minimum distance unvisited node
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] &&
                        (u == -1 || dist[j] < dist[u])) {

                    u = j;
                }
            }

            // Add node to MST
            visited[u] = true;
            totalCost += dist[u];

            // Relax all edges of u
            for (Edges edge : graph[u]) {

                int v = edge.dest;

                if (!visited[v] && edge.wt < dist[v]) {

                    dist[v] = edge.wt;
                }
            }
        }

        return totalCost;
    }
}