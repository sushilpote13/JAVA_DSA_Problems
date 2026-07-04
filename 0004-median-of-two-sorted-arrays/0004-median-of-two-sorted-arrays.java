class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int total = n + m;
        int median = total / 2;

        int pointerL = 0, pointerR = 0;
        int prev = 0, curr = 0;

        for (int i = 0; i <= median; i++) {

            prev = curr;

            if (pointerL >= n) {
                curr = nums2[pointerR++];
            } else if (pointerR >= m) {
                curr = nums1[pointerL++];
            } else if (nums1[pointerL] <= nums2[pointerR]) {
                curr = nums1[pointerL++];
            } else {
                curr = nums2[pointerR++];
            }
        }

        if (total % 2 == 0) {
            return (prev + curr) / 2.0;
        }

        return curr;
    }
}