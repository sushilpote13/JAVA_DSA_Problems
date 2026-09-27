class Solution {

    static class Node {
        Node[] child = new Node[2];
    }

    public int findMaximumXOR(int[] nums) {
        Node root = new Node();

        // Build binary trie
        for (int num : nums) {
            Node curr = root;

            for (int bit = 30; bit >= 0; bit--) {
                int b = (num >> bit) & 1;

                if (curr.child[b] == null) {
                    curr.child[b] = new Node();
                }

                curr = curr.child[b];
            }
        }

        int maxXOR = 0;

        // Find best XOR for every number
        for (int num : nums) {
            Node curr = root;
            int xor = 0;

            for (int bit = 30; bit >= 0; bit--) {
                int b = (num >> bit) & 1;
                int opposite = b ^ 1;

                if (curr.child[opposite] != null) {
                    xor |= (1 << bit);
                    curr = curr.child[opposite];
                } else {
                    curr = curr.child[b];
                }
            }

            maxXOR = Math.max(maxXOR, xor);
        }

        return maxXOR;
    }
}