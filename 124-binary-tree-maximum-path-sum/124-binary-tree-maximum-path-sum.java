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
    
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        helper(root);
        return ans;
    }
    
    public int helper(TreeNode root){
        if(root==null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int maxSumIncludingMe = root.val;
        if(left>0) maxSumIncludingMe+=left;
        if(right>0) maxSumIncludingMe+=right;
        
        ans= Math.max(ans, maxSumIncludingMe);
        
        return root.val+Math.max(0, Math.max(left, right));//max possible downward sum
    }
}