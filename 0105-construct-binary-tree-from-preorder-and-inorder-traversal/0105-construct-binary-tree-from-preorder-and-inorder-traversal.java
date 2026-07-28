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
    public static void insertNode(int val, int inorderIndex, HashMap<Integer, Integer> map, TreeNode root) {
        // base condition if root is null
        if (root == null) {
            return;
        }

        // when to go to left
        if (inorderIndex < map.get(root.val)) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertNode(val, inorderIndex, map, root.left);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertNode(val, inorderIndex, map, root.right);
            }
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // create the HashMap for getting the indexes
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // insert the first element
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            insertNode(preorder[i], map.get(preorder[i]), map, root);
        }

        return root;
    }
}