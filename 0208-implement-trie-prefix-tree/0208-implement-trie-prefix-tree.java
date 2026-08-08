class Trie {

    static class Node {
        Node[] child = new Node[26];
        boolean end;
    }

    private final Node root = new Node();

    public Trie() {
    }

    public void insert(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (curr.child[index] == null)
                curr.child[index] = new Node();

            curr = curr.child[index];
        }

        curr.end = true;
    }

    public boolean search(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (curr.child[index] == null)
                return false;

            curr = curr.child[index];
        }

        return curr.end;
    }

    public boolean startsWith(String prefix) {

        Node curr = root;

        for (int i = 0; i < prefix.length(); i++) {

            int index = prefix.charAt(i) - 'a';

            if (curr.child[index] == null)
                return false;

            curr = curr.child[index];
        }

        return true;
    }
}