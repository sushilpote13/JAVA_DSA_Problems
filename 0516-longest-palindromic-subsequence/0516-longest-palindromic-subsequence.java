class Solution {
    public int longestPalindromeSubseq(String s) {

        int n = s.length();

        // dp[i][j] = longest palindromic subsequence
        // from index i to index j
        int[][] dp = new int[n][n];

        // Base case:
        // A single character is always a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Consider substrings of length 2, 3, 4, ...
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                // If both characters are same
                if (s.charAt(i) == s.charAt(j)) {

                    dp[i][j] = 2 + dp[i + 1][j - 1];

                } else {

                    // Skip either left or right character
                    dp[i][j] = Math.max(
                        dp[i + 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }

        return dp[0][n - 1];
    }
}