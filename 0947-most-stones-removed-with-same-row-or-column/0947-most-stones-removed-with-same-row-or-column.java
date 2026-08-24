class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;

        int[] parent = new int[n];
        int components = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] ||
                    stones[i][1] == stones[j][1]) {

                    if (union(parent, i, j)) {
                        components--;
                    }
                }
            }
        }

        return n - components;
    }

    private int find(int[] parent, int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private boolean union(int[] parent, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);

        if (pa == pb) {
            return false;
        }

        parent[pb] = pa;
        return true;
    }
}