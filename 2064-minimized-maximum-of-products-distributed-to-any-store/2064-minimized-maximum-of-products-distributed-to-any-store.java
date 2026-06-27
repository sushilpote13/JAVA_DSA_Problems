class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int high = Integer.MIN_VALUE;
        for (int i : quantities) {
            if (high < i)
                high = i;
        }
        int ans = Integer.MAX_VALUE, m = quantities.length, low = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int q : quantities) {
                count += (q + mid - 1) / mid; // integer ceil
            }
            if (count <= n) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}