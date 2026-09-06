class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];

        // Day 0
        dp[0][0] = 0;            // don't hold stock
        dp[0][1] = -prices[0];  // buy stock

        for (int i = 1; i < n; i++) {

            // Not holding stock
            dp[i][0] = Math.max(
                dp[i - 1][0],
                dp[i - 1][1] + prices[i]
            );

            // Holding stock
            dp[i][1] = Math.max(
                dp[i - 1][1],
                dp[i - 1][0] - prices[i]
            );
        }

        return dp[n - 1][0];
    }
}