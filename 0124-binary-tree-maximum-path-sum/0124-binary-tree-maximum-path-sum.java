class Solution {

    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return maxPath;
    }

    // Pass every node one by one
    public void traverse(TreeNode node) {
        if (node == null)
            return;

        calculate(node);

        traverse(node.left);
        traverse(node.right);
    }

    // Calculate the best path through this node
    public int calculate(TreeNode node) {
        if (node == null)
            return 0;

        int left = calculate(node.left);
        int right = calculate(node.right);

        // Ignore negative paths
        left = Math.max(0, left);
        right = Math.max(0, right);

        // Path passing through current node
        int currentPath = node.val + left + right;

        maxPath = Math.max(maxPath, currentPath);

        // Return the best single path upward
        return node.val + Math.max(left, right);
    }
}