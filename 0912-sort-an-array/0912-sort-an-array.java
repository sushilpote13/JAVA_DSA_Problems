class Solution {
    public static void merge(int[] nums, int[] temp, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        int idx = start;
        while (left <= mid && right <= end) {
            if (nums[left] <= nums[right]) {
                temp[idx++] = nums[left++];
            } else {
                temp[idx++] = nums[right++];
            }
        }
        while (left <= mid)
            temp[idx++] = nums[left++];
        while (right <= end)
            temp[idx++] = nums[right++];
        for (int i = start; i <= end; i++)
            nums[i] = temp[i];
    }

    public static void mergeSort(int[] nums, int[] temp, int start, int end) {
        if (start >= end)
            return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, temp, start, mid);
        mergeSort(nums, temp, mid + 1, end);
        if (nums[mid] <= nums[mid + 1])
            return;
        merge(nums, temp, start, mid, end);
    }

    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);
        return nums;
    }
}