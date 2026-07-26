class Solution {

    int ans = Integer.MAX_VALUE;
    Integer prev = null;

    public void inorder(TreeNode root) {

        if (root == null)
            return;

        inorder(root.left);

        if (prev != null) {
            ans = Math.min(ans, root.val - prev);
        }

        prev = root.val;

        inorder(root.right);
    }

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return ans;
    }
}