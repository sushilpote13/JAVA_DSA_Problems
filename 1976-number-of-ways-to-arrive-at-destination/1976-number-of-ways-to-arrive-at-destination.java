import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];

            adj.get(u).add(new int[]{v, time});
            adj.get(v).add(new int[]{u, time});
        }

        long[] dist = new long[n];
        long[] ways = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        pq.offer(new long[]{0, 0}); // {node, distance}

        int MOD = 1_000_000_007;

        while (!pq.isEmpty()) {

            long[] current = pq.poll();

            int node = (int) current[0];
            long time = current[1];

            // Ignore outdated entry
            if (time > dist[node]) {
                continue;
            }

            for (int[] edge : adj.get(node)) {

                int next = edge[0];
                int edgeTime = edge[1];

                long newTime = time + edgeTime;

                // Found a shorter path
                if (newTime < dist[next]) {
                    dist[next] = newTime;
                    ways[next] = ways[node];

                    pq.offer(new long[]{next, newTime});
                }

                // Found another shortest path
                else if (newTime == dist[next]) {
                    ways[next] =
                        (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}