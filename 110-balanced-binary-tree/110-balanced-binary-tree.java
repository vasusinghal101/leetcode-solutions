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
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root)[1] == 1;
    }
    
    public int[] isBalancedHelper(TreeNode root) {
        if(root == null) return new int[]{0,1};//[0]->height [1]->isBalanced
        
        int[] l = isBalancedHelper(root.left);
        int[] r = isBalancedHelper(root.right);
        int[] ans = new int[2];
        ans[0] = Math.max(l[0],r[0])+1;
        if((l[1]==0 || r[1]==0)){
            ans[1] = 0;
        }else{
            if(Math.abs(l[0]-r[0])<=1){
                ans[1] = 1;
            }else{
               ans[1] = 0;
            }
        }
        return ans;
    }
    
}