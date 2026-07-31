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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        fillList(root, 0, list);
        return list;
    }

    private void fillList(TreeNode node, int level, List<List<Integer>> list) {
        if (node == null) {
            return;
        }
        
        //create a new sub list
        if (level == list.size()) {
            list.add(new LinkedList<>()); // LinkedList makes addFirst O(1)
        }
        if (level % 2 == 0) {
            // Even level -> Left to Right
            list.get(level).add(node.val);
        } else {
            // Odd level -> Right to Left
            list.get(level).add(0, node.val); // Insert at front
        }
        fillList(node.left, level + 1, list);
        fillList(node.right, level + 1, list);
    }
}