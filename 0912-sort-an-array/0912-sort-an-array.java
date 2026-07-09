class Solution {
    public static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = 0;
        int lp = start;
        int rp = mid + 1;
        while (lp <= mid && rp <= end) {
            if (nums[lp] <= nums[rp]) {
                temp[i] = nums[lp];
                lp++;
            } else {
                temp[i] = nums[rp];
                rp++;
            }
            i++;
        }
        while (lp <= mid) {
            temp[i] = nums[lp];
            lp++;
            i++;
        }
        while (rp <= end) {
            temp[i] = nums[rp];
            rp++;
            i++;
        }
        for (int j = 0; j < temp.length; j++) {
            nums[start + j] = temp[j];
        }
    }

    public static void mergeSort(int[] nums, int starting, int ending) {
        if (starting == ending) {
            return;
        }
        int mid = starting + (ending - starting) / 2;
        mergeSort(nums, starting, mid);
        mergeSort(nums, mid + 1, ending);
        merge(nums, starting, mid, ending);
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}