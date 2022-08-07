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
    public int helper(TreeNode root, long target){
        if(root==null) return 0;
        int ans=0;
        if(target==root.val) ans++;
        ans+= helper(root.left, target - root.val);
        ans+= helper(root.right, target - root.val);
        return ans;
    }
    public int pathSum(TreeNode root, int target) {
        if(root==null) return 0;
        int ans=0;
         ans+= helper(root, target);
         ans+= pathSum(root.left, target);
         ans+= pathSum(root.right, target);
        return ans;
    }
}