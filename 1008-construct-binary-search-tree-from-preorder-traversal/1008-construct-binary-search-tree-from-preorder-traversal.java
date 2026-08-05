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
    public static void placeElement(TreeNode root, int val) {
        if (root.val < val) {
            if (root.right != null) {
                placeElement(root.right, val);
            } else {
                root.right = new TreeNode(val);
            }
        } else if (root.val > val) {
            if (root.left != null) {
                placeElement(root.left, val);
            } else {
                root.left = new TreeNode(val);
            }
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            placeElement(root, preorder[i]);
        }
        return root;
    }
}