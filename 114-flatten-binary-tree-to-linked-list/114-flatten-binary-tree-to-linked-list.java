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
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    public TreeNode helper(TreeNode n){
        if(n==null){
            return null;
        }
        if(n.left==null){
            if(n.right==null){
                return n;
            }else{
                return helper(n.right);
            }
        }
        
        if(n.right==null){
            TreeNode lkt = helper(n.left);
            n.right = n.left;
            n.left = null;
            return lkt;
        }
        
        TreeNode rkt = helper(n.right);
        TreeNode lkt = helper(n.left);
        
        TreeNode temp = n.right;
        n.right = n.left;
        n.left = null;
        lkt.right = temp;
        
        return rkt;
    }
}