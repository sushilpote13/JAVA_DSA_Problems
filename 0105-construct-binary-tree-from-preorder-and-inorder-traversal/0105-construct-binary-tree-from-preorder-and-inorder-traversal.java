import java.util.HashMap;

class Solution {

    public static void insertNode(int val, int inorderIndex,
                                  HashMap<Integer, Integer> map,
                                  TreeNode root) {

        if (root == null) {
            return;
        }

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

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            insertNode(preorder[i], map.get(preorder[i]), map, root);
        }

        return root;
    }
}