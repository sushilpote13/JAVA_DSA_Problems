class Solution {

    int timer = 0;

    public void dfs(int curr, int parent,
                    ArrayList<Integer>[] graph,
                    boolean[] vis,
                    int[] dt,
                    int[] low,
                    List<List<Integer>> ans) {

        vis[curr] = true;

        dt[curr] = low[curr] = timer++;

        for (int neighbor : graph[curr]) {

            // Don't go back to parent
            if (neighbor == parent) {
                continue;
            }

            // Back edge
            if (vis[neighbor]) {
                low[curr] = Math.min(low[curr], dt[neighbor]);
            }

            // Unvisited neighbor
            else {

                dfs(neighbor, curr, graph,
                    vis, dt, low, ans);

                low[curr] = Math.min(low[curr], low[neighbor]);

                // Critical edge
                if (low[neighbor] > dt[curr]) {
                    ans.add(Arrays.asList(curr, neighbor));
                }
            }
        }
    }

    public List<List<Integer>> criticalConnections(
            int n, List<List<Integer>> connections) {

        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> edge : connections) {

            int u = edge.get(0);
            int v = edge.get(1);

            graph[u].add(v);
            graph[v].add(u);
        }

        List<List<Integer>> ans = new ArrayList<>();

        boolean[] vis = new boolean[n];
        int[] dt = new int[n];
        int[] low = new int[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, -1, graph, vis, dt, low, ans);
            }
        }

        return ans;
    }
}