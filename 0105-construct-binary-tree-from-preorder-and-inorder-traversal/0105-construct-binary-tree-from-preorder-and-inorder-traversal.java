import java.util.HashMap;

class Solution {

    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1, map);
    }

    private TreeNode build(int[] preorder, int left, int right,
                           HashMap<Integer, Integer> map) {

        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex++]);

        int mid = map.get(root.val);

        root.left = build(preorder, left, mid - 1, map);
        root.right = build(preorder, mid + 1, right, map);

        return root;
    }
}