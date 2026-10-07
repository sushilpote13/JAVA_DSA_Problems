class Solution {
    public int countPairs(int[] nums, int k) {

        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            int g = gcd(i, k);

            map.putIfAbsent(nums[i], new HashMap<>());

            HashMap<Integer, Integer> freq = map.get(nums[i]);

            // Check possible gcd values
            for (int d = 1; d * d <= k; d++) {

                if (k % d == 0) {

                    // d
                    if ((g * d) % k == 0) {
                        count += freq.getOrDefault(d, 0);
                    }

                    // k / d
                    int other = k / d;

                    if (other != d && (g * other) % k == 0) {
                        count += freq.getOrDefault(other, 0);
                    }
                }
            }

            freq.put(g, freq.getOrDefault(g, 0) + 1);
        }

        return count;
    }

    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}