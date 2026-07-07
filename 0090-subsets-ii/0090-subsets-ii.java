class Solution {
    public static void backtrack(int[] nums, int index, List<Integer> subset, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        // all subset that include nums[i]
        subset.add(nums[index]);
        backtrack(nums, index + 1, subset, res);
        subset.remove(subset.size() - 1);
        // all subsets that don't include nums[i]
        while ((index + 1 < nums.length) && nums[index] == nums[index + 1]) {
            index += 1;
        }
        backtrack(nums, index + 1, subset, res);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, list, res);
        return res;
    }
}