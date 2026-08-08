class Solution {
    class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }
    Node root = new Node();
    // Insert a word into Trie
    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // Build Trie
        for (String str : strs) {
            insert(str);
        }
        StringBuilder ans = new StringBuilder();
        Node curr = root;
        while (!curr.eow) {
            int count = 0;
            int nextIndex = -1;
            // Count children
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    count++;
                    nextIndex = i;
                }
            }
            // More than one child -> prefix ends
            if (count != 1) {
                break;
            }
            // Move to the only child
            ans.append((char) ('a' + nextIndex));
            curr = curr.children[nextIndex];
        }
        return ans.toString();
    }
}