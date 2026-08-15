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

    public class Info implements Comparable<Info> {
        int v;
        int cost;
        int stops;

        public Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }

        @Override
        public int compareTo(Info other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // creating graph using flights
        ArrayList<Edges>[] graph = new ArrayList[n];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // fill the graph
        for (int i = 0; i < flights.length; i++) {
            int source = flights[i][0];
            int dest = flights[i][1];
            int cost = flights[i][2];

            graph[source].add(new Edges(source, dest, cost));
        }

        // dist[node][stops]
        int[][] dist = new int[n][k + 2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[src][0] = 0;

        PriorityQueue<Info> q = new PriorityQueue<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {

            Info curr = q.remove();

            // Check stops BEFORE returning destination
            if (curr.stops > k + 1) {
                continue;
            }

            if (curr.v == dst) {
                return curr.cost;
            }

            // Already used maximum number of flights
            if (curr.stops == k + 1) {
                continue;
            }

            for (int i = 0; i < graph[curr.v].size(); i++) {

                Edges e = graph[curr.v].get(i);

                int v = e.dest;
                int wt = e.cost;

                int newCost = curr.cost + wt;
                int newStops = curr.stops + 1;

                if (newCost < dist[v][newStops]) {

                    dist[v][newStops] = newCost;

                    q.add(new Info(
                        v,
                        newCost,
                        newStops
                    ));
                }
            }
        }

        return -1;
    }
}