class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;
        for (int right = 0; right < nums.length; right++) {
            // Add new element to window
            if (nums[right] == 0) {
                zeroCount++;
            }
            // Too many zeros -> shrink window
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            // Current valid window length
            int length = right - left + 1;
            maxLength = Math.max(maxLength, length);
        }
        return maxLength-1;
 
    }
}