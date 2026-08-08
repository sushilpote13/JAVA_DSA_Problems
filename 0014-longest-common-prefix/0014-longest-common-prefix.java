class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        int n = strs.length;
        for (int i = 1; i < n; i++) {
            int cured = 0;
            while (cured < ans.length() && cured < strs[i].length()) {
                if (ans.charAt(cured) == strs[i].charAt(cured)) {
                    cured++;
                } else {
                    break;
                }
            }

            ans = ans.substring(0, cured);
        }
        return ans;
    }
}