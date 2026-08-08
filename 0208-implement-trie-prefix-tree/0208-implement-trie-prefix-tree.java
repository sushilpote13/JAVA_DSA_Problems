class Trie {

    // Each node stores links to the next characters
    class Node {
        Node[] children = new Node[26];
        boolean endOfWord;
    }

    private Node root;

    // Constructor
    public Trie() {
        root = new Node();
    }

    // Insert a word into the Trie
    public void insert(String word) {

        Node curr = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            // Create node if it does not exist
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }

            curr = curr.children[index];
        }

        // Mark the last node as a complete word
        curr.endOfWord = true;
    }

    // Search for an exact word
    public boolean search(String word) {

        Node node = findNode(word);

        return node != null && node.endOfWord;
    }

    // Check whether any word starts with the given prefix
    public boolean startsWith(String prefix) {

        return findNode(prefix) != null;
    }

    // Finds the node reached after traversing the given string
    private Node findNode(String str) {

        Node curr = root;

        for (char ch : str.toCharArray()) {

            int index = ch - 'a';

            // Character path does not exist
            if (curr.children[index] == null) {
                return null;
            }

            curr = curr.children[index];
        }

        return curr;
    }
}