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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        boolean ans = false;
        if(root.val == subRoot.val){
            ans = isSame(root,subRoot);
            if(ans) return true;
        }
        
        ans = isSubtree(root.left , subRoot);
        if(ans) return true;
        ans = isSubtree(root.right , subRoot);
        
        return ans;
    }
    
    public boolean isSame(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(root.val != subRoot.val) return false;
        
        if(!isSame(root.left,subRoot.left)) return false;
        
        if(!isSame(root.right, subRoot.right)) return false;
        
        return true;
    }
}