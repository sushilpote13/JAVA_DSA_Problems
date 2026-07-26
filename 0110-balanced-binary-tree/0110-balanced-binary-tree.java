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
    public int checkHeight(TreeNode root) {
        // Base case
        if (root == null) {
            return 0;
        }
        // Get left subtree height
        int leftHeight = checkHeight(root.left);

        // If left subtree is unbalanced
        if (leftHeight == -1) {
            return -1;
        }

        // Get right subtree height
        int rightHeight = checkHeight(root.right);

        // If right subtree is unbalanced
        if (rightHeight == -1) {
            return -1;
        }

        // Check current node
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return current height
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
}