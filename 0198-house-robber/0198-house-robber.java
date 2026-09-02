class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];

        // base condition 
        dp[0] = 0;
        dp[1] = nums[0];
        for (int house = 2; house <= n; house++) {
            dp[house] = Math.max(nums[house-1] + dp[house - 2], dp[house - 1]);
        }
        return dp[n];
    }
}