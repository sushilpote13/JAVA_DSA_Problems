/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return maxPath;
    }

    // Visit every node
    public void traverse(TreeNode node) {
        if (node == null)
            return;

        calculate(node);

        traverse(node.left);
        traverse(node.right);
    }

    // Returns the best downward path from this node
    public int calculate(TreeNode node) {
        if (node == null)
            return 0;

        int left = calculate(node.left);
        int right = calculate(node.right);

        // Ignore negative paths
        if (left < 0)
            left = 0;

        if (right < 0)
            right = 0;

        // Path passing through this node
        int currentPath = left + node.val + right;

        if (currentPath > maxPath)
            maxPath = currentPath;

        // Return only one side to parent
        return node.val + Math.max(left, right);
    }
}