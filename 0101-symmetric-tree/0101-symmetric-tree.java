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
    public static boolean isMirror(TreeNode left, TreeNode right) {
        // basic condition if they are null they are same
        if (right == null && left == null) {
            return true;
        }

        // check for if any one is null or not 
        if (left == null || right == null) {
            return false;
        }

        // now once both condition are check go for it's nodes
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        // base condition is if it is null return null
        if(root == null){
            return true;
        }
        return isMirror(root.left , root.right);
    }
}