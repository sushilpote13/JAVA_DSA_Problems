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
    public static void printPreOrder(TreeNode root, List<Integer> list) {
        // base condition
        if (root == null) {
            return;
        }
        // preorder: root, left, right
        list.add(root.val);
        printPreOrder(root.left, list);
        printPreOrder(root.right, list);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        printPreOrder(root, ans);
        return ans;
    }
}