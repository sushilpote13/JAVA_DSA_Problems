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

        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();

            // At most k stops = k + 1 flights
            if (curr.stops > k) {
                continue;
            }

            // Important: don't update dist directly while processing
            int[] temp = dist.clone();

            for (int i = 0; i < graph[curr.v].size(); i++) {

                Edges e = graph[curr.v].get(i);

                int u = e.src;
                int v = e.dest;
                int wt = e.cost;

                if (curr.cost + wt < temp[v]) {

                    temp[v] = curr.cost + wt;

                    q.add(new Info(
                        v,
                        curr.cost + wt,
                        curr.stops + 1
                    ));
                }
            }

            dist = temp;
        }

        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[dst];
    }
}