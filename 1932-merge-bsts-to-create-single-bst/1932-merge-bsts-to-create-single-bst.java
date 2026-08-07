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

    private Map<Integer, TreeNode> roots = new HashMap<>();

    public TreeNode canMerge(List<TreeNode> trees) {

        Map<Integer, Integer> freq = new HashMap<>();

        // Store every root
        for (TreeNode root : trees) {
            roots.put(root.val, root);
            freq.put(root.val, freq.getOrDefault(root.val, 0) + 1);

            if (root.left != null)
                freq.put(root.left.val, freq.getOrDefault(root.left.val, 0) + 1);

            if (root.right != null)
                freq.put(root.right.val, freq.getOrDefault(root.right.val, 0) + 1);
        }

        TreeNode mainRoot = null;

        // Find the unique root
        for (TreeNode root : trees) {
            if (freq.get(root.val) == 1) {
                mainRoot = root;
                break;
            }
        }

        if (mainRoot == null)
            return null;

        roots.remove(mainRoot.val);

        if (!dfs(mainRoot, Long.MIN_VALUE, Long.MAX_VALUE))
            return null;

        // All trees must be merged
        if (!roots.isEmpty())
            return null;

        return mainRoot;
    }

    private boolean dfs(TreeNode node, long min, long max) {

        if (node == null)
            return true;

        if (node.val <= min || node.val >= max)
            return false;

        // Merge if current node is a leaf and another tree starts here
        if (node.left == null && node.right == null && roots.containsKey(node.val)) {

            TreeNode merge = roots.remove(node.val);

            node.left = merge.left;
            node.right = merge.right;
        }

        return dfs(node.left, min, node.val) &&
               dfs(node.right, node.val, max);
    }
}