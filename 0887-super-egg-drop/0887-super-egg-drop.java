class Solution {
    public int superEggDrop(int k, int n) {

        int[] dp = new int[k + 1];

        int attempts = 0;

        while (dp[k] < n) {

            attempts++;

            // Go backwards
            for (int eggs = k; eggs >= 1; eggs--) {

                dp[eggs] = dp[eggs] + dp[eggs - 1] + 1;
            }
        }

        return attempts;
    }
}