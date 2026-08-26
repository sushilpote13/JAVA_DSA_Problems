class Solution {
    public static void vistNode(int u, int[][] graph, boolean[] vist) {
        // vist the ndoe
        vist[u] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[u][i] == 1 && !vist[i]) {
                // vist that node
                vistNode(i, graph, vist);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vist = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && !vist[i]) {
                    count++;
                    vistNode(i, isConnected, vist);
                }
            }
        }

        return count;
    }
}