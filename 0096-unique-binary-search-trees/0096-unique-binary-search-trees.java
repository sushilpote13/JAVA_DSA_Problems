class Solution {
    public static int catatansNthNumber(int n, int[] dp) {
        // base condition 
        if (n == 0 || n == 1) {
            return 1;
        }
        // if already calculated 
        if(dp[n] != 0){
            return dp[n];
        }
        
        int ans = 0;
        // Recurssion
        for (int i = 0; i < n; i++) {
            ans += catatansNthNumber(i, dp) * catatansNthNumber(n - 1 - i, dp);
        }

        return ans;
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        
        return catatansNthNumber(n, dp);
    }
}