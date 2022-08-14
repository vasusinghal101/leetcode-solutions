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
    class Pair{
        int maxSum;
        int sum;
        boolean isBst;
        int max;
        int min;
        
        Pair(){
            this.maxSum = 0;
            this.sum = 0;
            this.isBst = true;
            this.max = Integer.MIN_VALUE;
            this.min = Integer.MAX_VALUE;
        }
        
    }
    public int maxSumBST(TreeNode root) {      
        Pair ans = helper(root);
        return ans.maxSum;
    }
    
    public Pair helper(TreeNode root){
        if(root == null) return new Pair();
        
        Pair l = helper(root.left);
        Pair r = helper(root.right);
        
        Pair p = new Pair();
        p.min = Math.min(root.val, Math.min(l.min, r.min));
        p.max = Math.max(root.val, Math.max(l.max, r.max));
        p.isBst = (!l.isBst || !r.isBst) ? false : (root.val>l.max && root.val< r.min) ? true :false;
        p.sum = root.val+l.sum+r.sum;
        p.maxSum = p.isBst ? Math.max(p.sum, Math.max(l.maxSum,r.maxSum)) : Math.max(l.maxSum,r.maxSum);
        return p;
    }
}