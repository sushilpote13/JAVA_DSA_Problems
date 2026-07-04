class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int[] candidates, int remain, int start,
                           List<Integer> temp, List<List<Integer>> ans) {

        if (remain == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (remain < 0)
            return;

        for (int i = start; i < candidates.length; i++) {

            if (candidates[i] > remain)
                break;

            if (i > start && candidates[i] == candidates[i - 1])
                continue;

            temp.add(candidates[i]);

            backtrack(candidates, remain - candidates[i], i + 1, temp, ans);

            temp.remove(temp.size() - 1);
        }
    }
}