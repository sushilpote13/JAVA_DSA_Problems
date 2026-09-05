class Solution {
    public int minDistance(String word1, String word2) {
        int n = word2.length();
        int m = word1.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word2.charAt(i - 1) == word1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int ans1 = 1 + dp[i - 1][j];     // Insert
                    int ans2 = 1 + dp[i][j - 1];     // Delete
                    int ans3 = 1 + dp[i - 1][j - 1]; // Replace

                    dp[i][j] = Math.min(ans1, Math.min(ans2, ans3));
                }
            }
        }

        return dp[n][m];
    }
}
