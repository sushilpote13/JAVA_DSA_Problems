class Solution {
    public boolean isMatch(String s, String p) {

        // length of both strings
        int n = s.length();
        int m = p.length();

        // DP table
        boolean dp[][] = new boolean[n + 1][m + 1];

        // Base condition
        dp[0][0] = true;

        // When s is empty
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // Case 1: '*'
                if (p.charAt(j - 1) == '*') {

                    // '*' matches:
                    // 1. zero characters
                    // 2. one or more characters
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }

                // Case 2: '?'
                else if (p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // Case 3: same character
                else if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // Case 4: different character
                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
}