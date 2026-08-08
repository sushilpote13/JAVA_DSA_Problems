class Trie {

    class Node {
        Node[] children = new Node[26];
        boolean endOfWord = false;
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }

            curr = curr.children[index];
        }

        curr.endOfWord = true;
    }

    public boolean search(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
        }

        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {

        Node curr = root;

        for (int i = 0; i < prefix.length(); i++) {

            int index = prefix.charAt(i) - 'a';

            if (curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
        }

        return true;
    }
}