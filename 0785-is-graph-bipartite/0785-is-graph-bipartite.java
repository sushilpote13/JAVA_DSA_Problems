class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        // 0 = not colored
        // 1 = color A
        // -1 = color B
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            // Already visited
            if (color[i] != 0) {
                continue;
            }
            // Start a new component
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            color[i] = 1;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbor : graph[node]) {
                    // Neighbor is not colored
                    if (color[neighbor] == 0) {
                        // Give opposite color
                        color[neighbor] = -color[node];
                        queue.add(neighbor);
                    }
                    // Neighbor has same color
                    else if (color[neighbor] == color[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}