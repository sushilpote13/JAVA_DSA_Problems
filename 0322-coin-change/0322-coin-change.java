class Solution {
    public int coinChange(int[] coins, int amount) {

        int INF = amount + 1;
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, INF);

        // Base condition 
        dp[0] = 0;

        // Unbounded Knapsack 
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {

                dp[j] = Math.min(
                        dp[j],
                        1 + dp[j - coin]);
            }
        }

        return dp[amount] == INF ? -1 : dp[amount];
    }
}