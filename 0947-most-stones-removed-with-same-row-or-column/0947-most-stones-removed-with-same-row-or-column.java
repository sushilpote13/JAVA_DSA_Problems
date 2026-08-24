class Solution {
    public int removeStones(int[][] stones) {
        int[] parent = new int[20002];
        boolean[] used = new boolean[20002];

        for (int i = 0; i < parent.length; i++)
            parent[i] = i;

        int components = 0;

        for (int[] s : stones) {
            int r = s[0];
            int c = s[1] + 10001;

            if (!used[r]) {
                used[r] = true;
                components++;
            }

            if (!used[c]) {
                used[c] = true;
                components++;
            }

            if (union(parent, r, c))
                components--;
        }

        return stones.length - components;
    }

    private int find(int[] p, int x) {
        while (p[x] != x) {
            p[x] = p[p[x]];
            x = p[x];
        }
        return x;
    }

    private boolean union(int[] p, int a, int b) {
        a = find(p, a);
        b = find(p, b);

        if (a == b)
            return false;

        p[b] = a;
        return true;
    }
}