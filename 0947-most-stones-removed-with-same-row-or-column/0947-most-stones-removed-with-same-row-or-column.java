public class Solution {

    public class Edges {
        int from;
        int to;

        public Edges(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;

        ArrayList<Edges>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Connect stones with same x or same y
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (stones[i][0] == stones[j][0] ||
                    stones[i][1] == stones[j][1]) {

                    graph[i].add(new Edges(i, j));
                    graph[j].add(new Edges(j, i));
                }
            }
        }

        boolean[] visited = new boolean[n];
        int removed = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                // DFS returns size of this component
                int size = dfs(i, graph, visited);

                // Keep one root, remove all other nodes
                removed += size - 1;
            }
        }

        return removed;
    }

    private int dfs(
        int node,
        ArrayList<Edges>[] graph,
        boolean[] visited
    ) {

        visited[node] = true;

        int count = 1;

        for (Edges edge : graph[node]) {

            int neighbor = edge.to;

            if (!visited[neighbor]) {
                count += dfs(neighbor, graph, visited);
            }
        }

        return count;
    }
}