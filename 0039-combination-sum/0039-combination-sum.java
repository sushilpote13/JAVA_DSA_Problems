class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain,
            int start) {
        for (int i = start; i < candidates.length; i++) {
            int val = candidates[i];
            int subtarget = remain - val;
            if (subtarget > 0) {
                tempList.add(val);
                backtrack(list, tempList, candidates, subtarget, i); // allow reuse of same element
                tempList.remove(tempList.size() - 1);
            } else if (subtarget == 0) {
                tempList.add(val);
                list.add(new ArrayList<>(tempList));
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}