class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int st = 0, en = n - 1;
        while (st < en) {
            int mid = st + (en - st) / 2;
            if (mid % 2 == 1)
                mid -= 1;
            if (nums[mid] == nums[mid + 1])
                st = mid + 2;
            else
                en = mid;
        }
        return nums[st];
    }
}