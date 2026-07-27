
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<TreeNode, TreeNode> parent = new HashMap<>();

    public void buildNode(TreeNode root, TreeNode par) {
        if (root == null) {
            return;
        }
        parent.put(root, par);
        buildNode(root.left, root);
        buildNode(root.right, root);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        buildNode(root, null);
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = parent.get(p);
        }
        while (!set.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }
}