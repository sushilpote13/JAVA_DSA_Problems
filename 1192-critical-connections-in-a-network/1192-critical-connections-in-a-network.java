class Solution {

    public void dfs(int curr, int parent,
                    ArrayList<Integer>[] graph,
                    boolean[] vis,
                    int[] dt,
                    int[] low,
                    int time,
                    List<List<Integer>> ans) {

        vis[curr] = true;
        dt[curr] = low[curr] = time;

        for (int neighbore : graph[curr]) {

            if (neighbore == parent) {
                continue;
            }

            if (vis[neighbore]) {
                low[curr] = Math.min(low[curr], dt[neighbore]);
            } 
            else {

                dfs(neighbore, curr, graph,
                    vis, dt, low, time + 1, ans);

                low[curr] = Math.min(low[curr], low[neighbore]);

                // Critical connection
                if (low[neighbore] > dt[curr]) {
                    ans.add(Arrays.asList(curr, neighbore));
                }
            }
        }
    }

    public List<List<Integer>> criticalConnections(
            int n, List<List<Integer>> connections) {

        // Create graph
        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Fill graph
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

        // Handle disconnected graph
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, -1, graph, vis, dt, low, 0, ans);
            }
        }

        return ans;
    }
}