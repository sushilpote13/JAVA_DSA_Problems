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
    public static int height(TreeNode Node) {
        // base condition 
        if (Node == null) {
            return 0;
        }
        int leftH = height(Node.left);
        int rightH = height(Node.right);
        int H = Math.max(leftH, rightH) + 1;
        return H;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftH = height(root.left);
        int rightH = height(root.right);
        if (!(Math.abs(leftH - rightH) <= 1)) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}