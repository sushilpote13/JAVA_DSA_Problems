class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }
        if (total % 2 != 0) {
            return false;
        }
        int target = total / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        // base conditions
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                //  check validity 
                if (nums[i - 1] <= j) {
                    // we have two choice 1.add it / 2. don't add the number
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i-1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }
}