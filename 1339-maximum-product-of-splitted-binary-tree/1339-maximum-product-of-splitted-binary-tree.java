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
    long ans=0, total=0;
    public int maxProduct(TreeNode root) {
        total = sum(root);
        sum(root);
        return (int)(ans%1000000007);
    }
    
    private long sum(TreeNode root){
        if(root==null)
            return 0;
        long left = sum(root.left);
        long right = sum(root.right);
        long s = left+right+root.val;
        ans = Math.max(ans, (long)s*(total-s));
        
        return s;
    }
}