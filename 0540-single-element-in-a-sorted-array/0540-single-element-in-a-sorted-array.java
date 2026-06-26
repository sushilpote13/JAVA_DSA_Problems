class Solution {
    public int singleNonDuplicate(int[] nums) {
        // solving by frequency list 
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i > max) {
                max = i;
            }
        }
        int[] freq = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}