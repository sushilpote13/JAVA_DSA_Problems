import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // Count word1
        for (char c : word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        // Count word2
        for (char c : word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        // Check same characters
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }

        // Get frequencies
        ArrayList<Integer> freq1 = new ArrayList<>(map1.values());
        ArrayList<Integer> freq2 = new ArrayList<>(map2.values());

        // Sort frequencies
        Collections.sort(freq1);
        Collections.sort(freq2);

        // Compare frequencies
        return freq1.equals(freq2);
    }
}