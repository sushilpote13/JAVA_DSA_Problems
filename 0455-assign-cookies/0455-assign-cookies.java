class Solution {
    public int findContentChildren(int[] g, int[] s) {

        int numStudent = g.length;
        int numCookies = s.length;

        // Base condition
        if (numCookies == 0 || numStudent == 0) {
            return 0;
        }

        // Sort both arrays
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // student pointer
        int j = 0; // cookie pointer
        int count = 0;

        while (i < numStudent && j < numCookies) {

            // Cookie can satisfy student
            if (s[j] >= g[i]) {
                count++;
                i++;
                j++;
            }
            // Cookie is too small
            else {
                j++;
            }
        }

        return count;
    }
}