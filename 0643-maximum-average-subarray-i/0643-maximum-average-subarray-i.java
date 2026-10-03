class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int sum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Slide the window
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];       // add new element
            sum -= nums[i - k];   // remove old element

            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}