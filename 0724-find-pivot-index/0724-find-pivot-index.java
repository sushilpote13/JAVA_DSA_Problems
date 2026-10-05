class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        int leftSum = 0;
        int pivot = 0;
        int rightSum = 0;

        for (int i = 1; i < n; i++) {
            rightSum += nums[i];
        }

        while (leftSum != rightSum && pivot < n - 1) {
            leftSum += nums[pivot++];
            rightSum -= nums[pivot];
        }

        if (leftSum != rightSum) {
            return -1;
        }

        return pivot;
    }
}