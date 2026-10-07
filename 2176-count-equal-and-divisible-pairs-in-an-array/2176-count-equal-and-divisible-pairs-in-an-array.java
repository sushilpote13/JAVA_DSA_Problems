class Solution {
    public int countPairs(int[] nums, int k) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            map.putIfAbsent(nums[i], new ArrayList<>());

            List<Integer> indices = map.get(nums[i]);

            for (int index : indices) {
                if ((index * i) % k == 0) {
                    count++;
                }
            }

            indices.add(i);
        }

        return count;
    }
}