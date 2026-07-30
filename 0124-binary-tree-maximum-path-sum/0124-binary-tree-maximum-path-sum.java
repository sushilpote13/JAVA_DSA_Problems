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
        calculate(root);
        return maxPath;
    }

    public int calculate(TreeNode node) {
        if (node == null)
            return 0;

        int left = Math.max(0, calculate(node.left));
        int right = Math.max(0, calculate(node.right));

        // Check if the best path passes through this node
        maxPath = Math.max(maxPath, left + right + node.val);

        // Return the best downward path to the parent
        return node.val + Math.max(left, right);
    }
}