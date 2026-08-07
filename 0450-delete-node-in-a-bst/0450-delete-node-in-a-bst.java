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
    public TreeNode deleteNode(TreeNode root, int key) {
        // base condition -> when root is null
        if (root == null) {
            // return null value 
            return null;
        }

        // true find the node 
        if (root.val == key) {
            // case 01 if key is a leaf node 
            if (root.left == root.right && root.left == null) {
                return null;
            }
            // case 02 if there is one child of key
            else if (root.left == null || root.right == null) {
                if (root.left == null) {
                    return root.right;
                }
                return root.left;
            }
            // case 03 if there are both child present
            else {
                TreeNode temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                root.val = temp.val;
                root.right = deleteNode(root.right, temp.val);
                return root;
            }
        } else if (key < root.val) {
            // key is in the left branch
            root.left = deleteNode(root.left, key);
        } else {
            // key is in the right branch
            root.right = deleteNode(root.right, key);
        }

        // if all values are checked return the root value back to parent 
        return root;
    }
}