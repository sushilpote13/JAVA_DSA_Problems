class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        // Impossible cases
        if (Math.abs(target) > total) {
            return 0;
        }

        // target = positiveSum - negativeSum
        // positiveSum + negativeSum = total
        //
        // positiveSum = (total + target) / 2

        if ((total + target) % 2 != 0) {
            return 0;
        }

        int sum = (total + target) / 2;

        // dp[i][j] = number of ways to make sum j
        // using first i elements
        int[][] dp = new int[n + 1][sum + 1];

        // Base condition
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Knapsack
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {

                // Check whether current element can be included
                if (nums[i - 1] <= j) {

                    // Include current element
                    int include = dp[i - 1][j - nums[i - 1]];

                    // Don't include current element
                    int exclude = dp[i - 1][j];

                    dp[i][j] = include + exclude;

                } else {

                    // Current element cannot be included
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}