class Solution {

    public void recursive(
        List<List<String>> result,
        List<String> current,
        String s,
        int start,
        boolean[][] dp
    ) {
        // Base condition
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < s.length(); i++) {

            // s[start...i] is palindrome
            if (dp[start][i]) {

                String substring = s.substring(start, i + 1);

                current.add(substring);

                // Move to next part
                recursive(result, current, s, i + 1, dp);

                // Backtracking
                current.remove(current.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {

        int n = s.length();

        // dp[i][j] = true if s[i...j] is palindrome
        boolean[][] dp = new boolean[n][n];

        // Build palindrome DP
        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || dp[i + 1][j - 1])) {

                    dp[i][j] = true;
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        recursive(result, current, s, 0, dp);

        return result;
    }
}