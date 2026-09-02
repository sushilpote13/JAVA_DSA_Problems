class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return solve(nums, nums.length - 1, dp);
    }

    public int solve(int[] nums, int i, int[] dp) {

        // Base case
        if (i < 0) {
            return 0;
        }
        // check if it is calculated in dp 
        if (dp[i] != -1) {
            return dp[i];
        }

        // Choice 1: Rob current house
        int robCurrent = nums[i] + solve(nums, i - 2, dp);

        // Choice 2: Skip current house
        int skipCurrent = solve(nums, i - 1, dp);

        // Take the maximum
        return dp[i] = Math.max(robCurrent, skipCurrent);
    }
}