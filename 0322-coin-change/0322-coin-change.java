import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // creating variables
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // base condition
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = -1;
        }

        // unbounded knapsack
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                // check the validity
                if (coins[i - 1] <= j) {
                    int use = dp[i][j - coins[i - 1]];
                    int skip = dp[i - 1][j];

                    if (use == -1 && skip == -1) {
                        dp[i][j] = -1;
                    } else if (use == -1) {
                        dp[i][j] = skip;
                    } else if (skip == -1) {
                        dp[i][j] = 1 + use;
                    } else {
                        dp[i][j] = Math.min(1 + use, skip);
                    }

                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][amount];
    }
}