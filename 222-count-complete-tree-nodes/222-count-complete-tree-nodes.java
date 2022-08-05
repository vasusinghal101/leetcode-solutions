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
    
    public int ldCount(TreeNode root){
        int ans = 0;
        while(root!=null){
            ans++;
            root=root.left;
        }
        return ans;
    }
    
    public int rdCount(TreeNode root){
        int ans = 0;
        while(root!=null){
            ans++;
            root = root.right;
        }
        return ans;
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int ld = ldCount(root);
        int rd = rdCount(root);
        
        if(ld==rd){
            return (1<<ld)-1;
        }else{
            return countNodes(root.left)+countNodes(root.right)+1;
        }
        
    }
}