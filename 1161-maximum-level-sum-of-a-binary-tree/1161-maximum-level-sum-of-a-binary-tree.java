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

    List<Integer> levelSums = new ArrayList<>();

    public int maxLevelSum(TreeNode root) {
        dfs(root, 0);

        int maxSum = Integer.MIN_VALUE;
        int ans = 1;

        for (int i = 0; i < levelSums.size(); i++) {
            if (levelSums.get(i) > maxSum) {
                maxSum = levelSums.get(i);
                ans = i + 1;
            }
        }

        return ans;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null)
            return;

        if (level == levelSums.size()) {
            levelSums.add(node.val);
        } else {
            levelSums.set(level, levelSums.get(level) + node.val);
        }

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
