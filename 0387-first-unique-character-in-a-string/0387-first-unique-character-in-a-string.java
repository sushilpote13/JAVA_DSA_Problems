class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            queue.offer(c);
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (charCount.get(c) == 1) {
                return s.indexOf(c);
            }
        }

        return -1;
    }
}