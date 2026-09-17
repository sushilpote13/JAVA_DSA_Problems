class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;

        int[] dpMax = new int[n];
        int[] dpMin = new int[n];

        // Base case
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        int ans = nums[0];

        // Fill DP table
        for (int i = 1; i < n; i++) {

            int num = nums[i];

            dpMax[i] = Math.max(
                num,
                Math.max(
                    num * dpMax[i - 1],
                    num * dpMin[i - 1]
                )
            );

            dpMin[i] = Math.min(
                num,
                Math.min(
                    num * dpMax[i - 1],
                    num * dpMin[i - 1]
                )
            );

            ans = Math.max(ans, dpMax[i]);
        }

        return ans;
    }
}