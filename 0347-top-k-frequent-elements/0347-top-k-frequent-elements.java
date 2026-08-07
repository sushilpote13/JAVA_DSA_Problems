import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        // Step 3: Keep only k most frequent elements
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 4: Store answer
        int[] ans = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            ans[i] = minHeap.poll().getKey();
        }

        return ans;
    }
}