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
class BSTIterator {
    // create the inorder and storing into the list
    private ArrayList<Integer> list;
    private int idx = -1;

    public void createList(TreeNode root) {
        // base condition 
        if (root == null) {
            return;
        }
        // left call
        createList(root.left);
        // add to the list 
        list.add(root.val);
        // right call
        createList(root.right);
    }

    public BSTIterator(TreeNode root) {
        // Initializes the arraylist after calling the class
        list = new ArrayList<>();
        createList(root);
    }

    public int next() {
        idx++;
        return list.get(idx);
    }

    public boolean hasNext() {
        // if the idx is out of the size of arraylist then there is no next 
        if (idx + 1 < list.size()) {
            return true;
        }
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */