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
    Integer curr = null;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        helper(root);
        return min;
    }
    
    public void helper(TreeNode root){
        if(root==null) return;
        
        helper(root.left);
        if(curr!=null) min=Math.min(min, Math.abs(root.val-curr));
        curr=root.val;
        helper(root.right);
    }
}