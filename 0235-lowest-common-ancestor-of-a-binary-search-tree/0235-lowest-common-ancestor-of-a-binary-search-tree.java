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
    public static void buildList(TreeNode root, TreeNode target,
            ArrayList<TreeNode> list) {

        if (root == null)
            return;

        list.add(root);

        if (root == target)
            return;

        if (target.val < root.val)
            buildList(root.left, target, list);
        else
            buildList(root.right, target, list);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // find the path and store in the list 
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();

        buildList(root, p, list1);
        buildList(root, q, list2);
        int i = 0;
        while (i < list1.size() && i < list2.size() && list1.get(i) == list2.get(i)) {
            i++;
        }
        return list1.get(i - 1);
    }

}