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
    public int bfs(TreeNode root,int level,int id,ArrayList<Integer> list){
        if(root==null){
            return 0;
        }

        if(level==list.size()){
            list.add(id);
        }

        int curr=id-list.get(level)+1;
        int left=bfs(root.left,level+1,2*id+1,list);
        int right=bfs(root.right,level+1,2*id+2,list);

        return Math.max(curr,Math.max(left,right));
    }
    public int widthOfBinaryTree(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        return bfs(root,0,1,list);
    }

}