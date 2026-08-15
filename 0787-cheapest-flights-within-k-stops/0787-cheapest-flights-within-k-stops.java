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

    public class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights,
            int src, int dst, int k) {

        // Create graph
        ArrayList<Edges>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Fill graph
        for (int i = 0; i < flights.length; i++) {
            int source = flights[i][0];
            int dest = flights[i][1];
            int cost = flights[i][2];

            graph[source].add(new Edges(source, dest, cost));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            // More than k stops is not allowed
            if (curr.stops > k) {
                continue;
            }

            for (Edges e : graph[curr.v]) {
                int v = e.dest;
                int cost = e.cost;
                if (curr.cost + cost < dist[v]) {
                    dist[v] = curr.cost + cost;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}