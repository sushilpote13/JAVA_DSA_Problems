class Solution {

    public boolean bfs(int src, int target,
                       ArrayList<Integer>[] graph,
                       boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {

            int curr = queue.remove();

            // Target found
            if (curr == target) {
                return true;
            }

            // Visit all neighbours
            for (int next : graph[curr]) {

                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        // Create graph
        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Process every edge
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            // Fresh visited array for every edge
            boolean[] visited = new boolean[n + 1];

            // Check if path already exists
            if (bfs(u, v, graph, visited)) {
                return edge;
            }

            // No path -> safely add edge
            graph[u].add(v);
            graph[v].add(u);
        }

        return new int[0];
    }
}