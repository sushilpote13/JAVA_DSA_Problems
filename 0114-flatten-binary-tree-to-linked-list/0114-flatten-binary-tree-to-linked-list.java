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

    public void flatten(TreeNode root) {

        if (root == null)
            return;

        // Flatten left subtree
        flatten(root.left);

        // Flatten right subtree
        flatten(root.right);

        // Store original right subtree
        TreeNode originalRight = root.right;

        // Move left subtree to right
        root.right = root.left;
        root.left = null;

        // Find last node of new right subtree
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }

        // Attach original right subtree
        curr.right = originalRight;
    }
}