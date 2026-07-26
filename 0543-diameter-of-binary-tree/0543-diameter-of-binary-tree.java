class Solution {

    class Info {
        int height;
        int diameter;

        Info(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public Info diameter(TreeNode root) {

        if (root == null) {
            return new Info(0, 0);
        }

        Info left = diameter(root.left);
        Info right = diameter(root.right);

        int leftH = left.height;
        int rightH = right.height;

        int leftD = left.diameter;
        int rightD = right.diameter;

        int selfHeight = Math.max(leftH, rightH) + 1;
        int selfDiameter = leftH + rightH;

        int finalDiameter = Math.max(selfDiameter, Math.max(leftD, rightD));

        return new Info(selfHeight, finalDiameter);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root).diameter;
    }
}