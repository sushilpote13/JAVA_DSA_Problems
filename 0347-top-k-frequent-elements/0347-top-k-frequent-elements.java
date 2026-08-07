class Solution {
    class Pair {
        int num;
        int freq;

        Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        // count the frequency of each element and stor it in the hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // create a Priority Queue on the hashmap
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        for (int key : map.keySet()) {
            minHeap.offer(new Pair(key, map.get(key)));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // create the int[] and append all the values in that array 
        int[] ans = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            ans[i] = minHeap.poll().num;
        }

        return ans;
    }
}