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
    int ans = 0;
    public int findTilt(TreeNode root) {
        ans=0;
        helperTilt(root);
        return ans;
    }
    public int helperTilt(TreeNode root) {
        if(root == null) return 0;
        
        if(root.left == null && root.right==null){
            return root.val;
        }
        int ls = helperTilt(root.left);
        int rs = helperTilt(root.right);
        ans += Math.abs(ls-rs);
        return ls+rs+root.val;
    }
}