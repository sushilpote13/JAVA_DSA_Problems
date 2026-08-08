class Solution {

    class Node {
        Node[] children = new Node[26];
        boolean end = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    Node root = new Node();

    Boolean[] memo;

    public void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.end = true;
    }

    public boolean search(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return curr.end;
    }

    public boolean searchKey(String s, int start) {

        if (start == s.length()) {
            return true;
        }

        if (memo[start] != null) {
            return memo[start];
        }

        Node curr = root;

        for (int i = start; i < s.length(); i++) {

            int idx = s.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                break;
            }

            curr = curr.children[idx];

            if (curr.end && searchKey(s, i + 1)) {
                return memo[start] = true;
            }
        }

        return memo[start] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        for (int i = 0; i < wordDict.size(); i++) {
            insert(wordDict.get(i));
        }

        memo = new Boolean[s.length()];

        return searchKey(s, 0);
    }
}
