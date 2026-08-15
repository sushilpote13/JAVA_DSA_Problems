class Solution {

    public class Edges {
        int src;
        int dest;
        int cost;

        public Edges(int src, int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Create graph
        ArrayList<Edges>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Fill graph
        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int cost = flights[i][2];

            graph[from].add(new Edges(from, to, cost));
        }

        // dist[i] = cheapest cost to reach i
        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        // At most k stops means at most k + 1 flights
        for (int stops = 0; stops <= k; stops++) {

            int[] temp = dist.clone();

            for (int u = 0; u < n; u++) {

                if (dist[u] == Integer.MAX_VALUE) {
                    continue;
                }

                for (Edges e : graph[u]) {

                    int v = e.dest;
                    int wt = e.cost;

                    if (dist[u] + wt < temp[v]) {
                        temp[v] = dist[u] + wt;
                    }
                }
            }

            dist = temp;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}