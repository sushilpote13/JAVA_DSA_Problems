class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = {0, -prices[0]};

        for (int i = 1; i < prices.length; i++) {
            int notHold = Math.max(dp[0], dp[1] + prices[i]);
            int hold = Math.max(dp[1], dp[0] - prices[i]);

            dp[0] = notHold;
            dp[1] = hold;
        }

        return dp[0];
    }
}