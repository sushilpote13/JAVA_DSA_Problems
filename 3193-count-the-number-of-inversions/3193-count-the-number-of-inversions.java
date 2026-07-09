import java.util.Arrays;

class Solution {
    public int numberOfPermutations(int n, int[][] requirements) {
        final int MOD = 1_000_000_007;

        // req[i] = required inversions for prefix ending at i
        int[] req = new int[n];
        Arrays.fill(req, -1);

        int maxInv = 0;
        for (int[] r : requirements) {
            req[r[0]] = r[1];
            maxInv = Math.max(maxInv, r[1]);
        }

        // Prefix of length 1 can only have 0 inversions.
        if (req[0] > 0) return 0;
        req[0] = 0;

        // dp[i][j] = number of permutations of [0...i]
        // having exactly j inversions.
        int[][] dp = new int[n][maxInv + 1];
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {

            int left = 0;
            int right = maxInv;

            // If this prefix has a required inversion count,
            // compute only that state.
            if (req[i] != -1) {
                left = right = req[i];
            }

            for (int inv = left; inv <= right; inv++) {

                long ways = 0;

                // Place the new largest element.
                // It can create k new inversions.
                for (int k = 0; k <= Math.min(i, inv); k++) {
                    ways += dp[i - 1][inv - k];
                }

                dp[i][inv] = (int) (ways % MOD);
            }
        }

        return dp[n - 1][req[n - 1]];
    }
}