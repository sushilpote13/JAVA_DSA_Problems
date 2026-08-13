class Solution {

    public boolean dfs(int curr, int target,
                       ArrayList<Integer>[] graph,
                       boolean[] visited) {

        if (curr == target) {
            return true;
        }

        visited[curr] = true;

        for (int next : graph[curr]) {

            if (!visited[next]) {

                if (dfs(next, target, graph, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            boolean[] visited = new boolean[n + 1];

            if (dfs(u, v, graph, visited)) {
                return edge;
            }

            graph[u].add(v);
            graph[v].add(u);
        }

        return new int[0];
    }
}