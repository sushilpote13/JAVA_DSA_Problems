class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        int total = n1 + n2;

        int mid1 = (total - 1) / 2;
        int mid2 = total / 2;

        int i = 0, j = 0;
        int index = 0;

        int first = 0, second = 0;

        while (i < n1 || j < n2) {

            int val;

            if (i < n1 && (j >= n2 || nums1[i] <= nums2[j])) {
                val = nums1[i];
                i++;
            } else {
                val = nums2[j];
                j++;
            }

            if (index == mid1)
                first = val;

            if (index == mid2) {
                second = val;
                break;
            }

            index++;
        }

        if (total % 2 == 1)
            return second;

        return (first + second) / 2.0;
    }
}