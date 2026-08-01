class KthLargest {

    class TreeNode {
        int val;
        int count;   // Number of duplicates
        int size;    // Total nodes in subtree
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.count = 1;
            this.size = 1;
        }
    }

    private TreeNode root;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            root = insert(root, num);
        }
    }

    private TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }

        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        } else {
            node.count++;
        }

        node.size = size(node.left) + size(node.right) + node.count;
        return node;
    }

    private int size(TreeNode node) {
        return node == null ? 0 : node.size;
    }

    private int kthLargest(TreeNode node, int k) {
        int rightSize = size(node.right);

        if (k <= rightSize) {
            return kthLargest(node.right, k);
        }

        if (k <= rightSize + node.count) {
            return node.val;
        }

        return kthLargest(node.left, k - rightSize - node.count);
    }

    public int add(int val) {
        root = insert(root, val);
        return kthLargest(root, k);
    }
}