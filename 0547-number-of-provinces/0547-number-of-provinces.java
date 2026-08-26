class Solution {

    public static void visitNode(int u, int[][] graph, boolean[] visited) {
        visited[u] = true;

        for (int i = 0; i < graph.length; i++) {
            if (graph[u][i] == 1 && !visited[i]) {
                visitNode(i, graph, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                count++;

                visitNode(i, isConnected, visited);
            }
        }

        return count;
    }
}