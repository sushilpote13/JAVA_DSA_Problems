class Solution {
    public class Pair implements Comparable<Pair> {
        int val;
        int dist;
        public Pair(int val, int dist) {
            this.val = val;
            this.dist = dist;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist;
        }
    }
    public class Edge {
        int src;
        int dest;
        int dist;
        public Edge(int src, int dest, int dist) {
            this.src = src;
            this.dest = dest;
            this.dist = dist;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int v = points.length;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < v; i++) {

            for (int j = i + 1; j < v; j++) {

                int dist =
                    Math.abs(points[i][0] - points[j][0])
                    + Math.abs(points[i][1] - points[j][1]);

                graph[i].add(new Edge(i, j, dist));
                graph[j].add(new Edge(j, i, dist));
            }
        }

        boolean[] visited = new boolean[v];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int totalCost = 0;
        int count = 0;
        while (!pq.isEmpty() && count < v) {
            Pair curr = pq.remove();
            int vertex = curr.val;
            int cost = curr.dist;
            if (visited[vertex]) {
                continue;
            }
            visited[vertex] = true;
            totalCost += cost;
            count++;
            for (Edge e : graph[vertex]) {
                if (!visited[e.dest]) {
                    pq.add(new Pair(e.dest, e.dist));
                }
            }
        }
        return totalCost;
    }
}