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
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterHelper(root)[1]-1;
    }
    //int[0] -> height
    //int[1] -> Diameter
    public int[] diameterHelper(TreeNode root){
        if(root == null) return new int[]{0,0};
        
        int[] ans = new int[2];
        
        int[] l = diameterHelper(root.left);
        int[] r = diameterHelper(root.right);
        
        ans[0] = Math.max(l[0],r[0])+1;
        ans[1] = Math.max(Math.max(l[1],r[1]), l[0]+r[0]+1);
        
        return ans;
    }
}