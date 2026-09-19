class Solution {
    public int minimumMountainRemovals(int[] nums) {
        // left    [1,1,1,2,3,1...
        // let say [2,1,1,5,6,2,3,1]
        // right      ...,3,3,2,2,1]

        int n = nums.length;

        // creating two arrays:
        int left[] = new int[n];
        int right[] = new int[n];

        // initialize
        for (int i = 0; i < n; i++) {
            left[i] = 1;
            right[i] = 1;
        }

        // LIS from left to right
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // check increasing order nums[j] < nums[i]
                if (nums[j] < nums[i]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }

        // LDS from right to left
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // check decreasing order nums[j] <  nums[i]
                if (nums[j] < nums[i]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }

        // find longest mountain
        int maxMountain = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] > 1 && right[i] > 1) {
                int mountainLength = left[i] + right[i] - 1;
                maxMountain = Math.max(maxMountain, mountainLength);
            }
        }

        // return 
        return n - maxMountain;
    }
}