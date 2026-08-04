class Solution {

    public void createInorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;

        createInorder(root.left, list);
        list.add(root.val);
        createInorder(root.right, list);
    }

    public void placeValue(TreeNode root, ArrayList<Integer> list, int[] idx) {
        if (root == null) return;

        placeValue(root.left, list, idx);

        root.val = list.get(idx[0]);
        idx[0]++;

        placeValue(root.right, list, idx);
    }

    public void recoverTree(TreeNode root) {

        ArrayList<Integer> inorder = new ArrayList<>();

        createInorder(root, inorder);

        Collections.sort(inorder);

        int[] idx = {0};

        placeValue(root, inorder, idx);
    }
}