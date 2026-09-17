class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int maxEnding = nums[0];
        int minEnding = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                int temp = maxEnding;
                maxEnding = minEnding;
                minEnding = temp;
            }
            maxEnding = Math.max(num, maxEnding * num);
            minEnding = Math.min(num, minEnding * num);
            maxProduct = Math.max(maxProduct, maxEnding);
        }

        return maxProduct;
    }
}