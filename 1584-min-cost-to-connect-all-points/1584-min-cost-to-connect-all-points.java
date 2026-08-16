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

    public class Info implements Comparable<Info> {
        int v;
        int cost;

        public Info(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info i2) {
            return this.cost - i2.cost;
        }
    }

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        // -------------------------
        // STEP 1: Build Graph
        // -------------------------

        ArrayList<Edges>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int wt = Math.abs(points[i][0] - points[j][0])
                       + Math.abs(points[i][1] - points[j][1]);

                graph[i].add(new Edges(i, j, wt));
                graph[j].add(new Edges(j, i, wt));
            }
        }

        // -------------------------
        // STEP 2: Prim's Algorithm
        // -------------------------

        boolean[] visited = new boolean[n];

        PriorityQueue<Info> pq = new PriorityQueue<>();

        // Start from node 0
        pq.add(new Info(0, 0));

        int totalCost = 0;

        while (!pq.isEmpty()) {

            Info curr = pq.remove();

            int u = curr.v;
            int cost = curr.cost;

            // Already included in MST
            if (visited[u]) {
                continue;
            }

            // Include this vertex
            visited[u] = true;

            // Add edge cost
            totalCost += cost;

            // Visit neighbors
            for (Edges edge : graph[u]) {

                int v = edge.dest;

                if (!visited[v]) {

                    pq.add(new Info(v, edge.wt));
                }
            }
        }

        return totalCost;
    }
}