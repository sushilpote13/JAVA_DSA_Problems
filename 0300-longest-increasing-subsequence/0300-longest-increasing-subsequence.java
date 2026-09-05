class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // Create a set with no duplicate values
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        // Convert set to array
        Integer[] nums2 = set.toArray(new Integer[0]);

        // Sort the array
        Arrays.sort(nums2);

        // Length of unique array
        int m = nums2.length;

        // Create DP table for LCS
        int[][] dp = new int[n + 1][m + 1];

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If elements match
                if (nums[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Take the maximum
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Return the LCS length
        return dp[n][m];
    }
}
