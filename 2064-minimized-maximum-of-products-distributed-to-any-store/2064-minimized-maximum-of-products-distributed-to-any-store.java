class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int high = Integer.MIN_VALUE;
        for (int i : quantities) {
            if (high < i) {
                high = i;
            }
        }
        int low = 1;
        int mid = low + ((high - low) / 2);
        while (low <= high) {
            int count = 0;
            for (int i : quantities) {
                count += Math.ceil(i / (double) mid);
            }
            if (count > n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = low + ((high - low) / 2);
        }
        return mid;
    }
}