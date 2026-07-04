import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int[] candidates, int remain, int start,
                           List<Integer> temp, List<List<Integer>> ans) {

        // Base Case
        if (remain == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // No need to continue further
            if (candidates[i] > remain)
                break;

            temp.add(candidates[i]);

            // Reuse the same element
            backtrack(candidates, remain - candidates[i], i, temp, ans);

            // Backtrack
            temp.remove(temp.size() - 1);
        }
    }
}