class Solution {
    public class Edges {
        int val;
        int dest;

        public Edges(int val, int dest) {
            this.val = val;
            this.dest = dest;
        }
    }

    public void dfs(int curr, int parent, ArrayList<Edges>[] graph, boolean[] vis, int[] dt, int[] low, int time, List<List<Integer>> ans) {
        vis[curr] = true;
        dt[curr] = low[curr] = time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edges e = graph[curr].get(i);
            int neighbore = e.dest;

            // it should not be parent
            if (neighbore == parent) {
                continue;
            }

            // if neighbor is visited
            if (vis[neighbore]) {
                low[curr] = Math.min(low[curr], dt[neighbore]);
            } else {
                dfs(neighbore, curr, graph, vis, dt, low, time + 1, ans);

                low[curr] = Math.min(low[curr], low[neighbore]);

                // This is a critical connection
                if (low[neighbore] > dt[curr]) {
                    ans.add(Arrays.asList(curr, neighbore));
                }
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // Step one: create the graph
        ArrayList<Edges>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Fill the graph
        for (int i = 0; i < connections.size(); i++) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);

            graph[u].add(new Edges(u, v));
            graph[v].add(new Edges(v, u));
        }

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];
        int[] dt = new int[n];
        int[] low = new int[n];

        // Graph can have multiple components
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, -1, graph, vis, dt, low, 0, ans);
            }
        }

        return ans;
    }
}