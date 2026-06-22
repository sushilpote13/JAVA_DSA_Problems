class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int st = 0;
        int en = arr.length - 1;
        while (st < en) {
            int mid = st + (en - st) / 2;
            if (arr[mid] < arr[mid + 1]) {
                st = mid + 1;  // Peak is on the right
            } else {
                en = mid;      // Peak is at mid or on the left
            }
        }
        return st; // st == en == peak index
    }
}