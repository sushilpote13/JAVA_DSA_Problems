class Solution {

    public void backtrack(int[] nums, int start, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {

            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1])
                continue;

            subset.add(nums[i]);
            backtrack(nums, i + 1, subset, res);
            subset.remove(subset.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);

        return res;
    }
}