class Solution {
    public int minimizedMaximum(int n, int[] quantities) {

        int low = 1;
        int high = 0;

        for (int q : quantities)
            high = Math.max(high, q);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int count = 0;
            for (int q : quantities) {
                count += (q + mid - 1) / mid;   // integer ceil
                if (count > n) break;           // early exit
            }

            if (count > n)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }
}