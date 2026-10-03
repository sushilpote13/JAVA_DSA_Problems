class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int st = 0;
        int en = nums.length - 1;
        int count = 0;
        while (st < en) {
            int sum = nums[st] + nums[en];
            if (sum == k) {
                count++;
                st++;
                en--;
            }
            else if (sum < k) {
                st++;
            }
            else {
                en--;
            }
        }
        return count;
    }
}