class Solution {

    int[] parent;
    int[] rank;

    // Find the ultimate parent
    public int find(int x) {

        if (parent[x] == x) {
            return x;
        }

        // Path compression
        return parent[x] = find(parent[x]);
    }

    // Union two components
    public boolean union(int u, int v) {

        int pu = find(u);
        int pv = find(v);

        // Already connected -> cycle
        if (pu == pv) {
            return false;
        }

        // Union by rank
        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        }
        else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        }
        else {
            parent[pv] = pu;
            rank[pu]++;
        }

        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        parent = new int[n + 1];
        rank = new int[n + 1];

        // Initially every node is its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            // If union fails, cycle exists
            if (!union(u, v)) {
                return edge;
            }
        }

        return new int[0];
    }
}