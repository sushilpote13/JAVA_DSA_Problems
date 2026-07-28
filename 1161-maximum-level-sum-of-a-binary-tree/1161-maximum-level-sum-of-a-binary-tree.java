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
    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        int bestSum = Integer.MIN_VALUE;
        int levelSum = 0;
        int bestLevel = 1;
        int k = 1;

        while (!q.isEmpty()) {
            TreeNode cur = q.remove();
            if (cur == null) {
                if (levelSum > bestSum) {
                    bestSum = levelSum;
                    bestLevel = k;
                }
                if (q.isEmpty()) {
                    break;
                }
                levelSum = 0;
                k++;
                q.add(null);
            } else {
                levelSum += cur.val;
                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
            }
        }
        return bestLevel;
    }
}