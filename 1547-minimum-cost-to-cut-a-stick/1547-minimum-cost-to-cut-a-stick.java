class Solution {

    public int minCost(int n, int[] cuts) {
        int m = cuts.length;

        // Add 0 and n
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;

        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }

        Arrays.sort(arr);

        int[][] dp = new int[m + 2][m + 2];

        return solve(0, m + 1, arr, dp);
    }

    private int solve(int left, int right, int[] cuts, int[][] dp) {

        // No cut between left and right
        if (right - left <= 1) {
            return 0;
        }

        if (dp[left][right] != 0) {
            return dp[left][right];
        }

        int ans = Integer.MAX_VALUE;

        // Try EVERY possible cut between left and right
        for (int i = left + 1; i < right; i++) {

            int cost = cuts[right] - cuts[left];

            cost += solve(left, i, cuts, dp);
            cost += solve(i, right, cuts, dp);

            ans = Math.min(ans, cost);
        }

        dp[left][right] = ans;

        return ans;
    }
}