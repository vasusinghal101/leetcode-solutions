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
        boolean isBST;
        int min;
        int max;
        Pair(){
            this.isBST = false;
            this.min = Integer.MAX_VALUE;
            this.max = Integer.MIN_VALUE;
        }
        
        Pair(boolean isBST, int min, int max){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
    public boolean isValidBST(TreeNode root) {
        Pair ans = helper(root);
        return ans.isBST;
    }
    
    public Pair helper(TreeNode root){
        if(root == null) return null;
        Pair myPair = new Pair();
        if(root.left!=null){ 
            Pair left = helper(root.left);
            if(!left.isBST || left.max >= root.val){
                return new Pair();
            }
            myPair.min = left.min;
        }else{
            myPair.min = root.val;
        }
        
        if(root.right!=null){ 
            Pair right = helper(root.right);        
            if(!right.isBST || right.min <= root.val){
                return new Pair();
            }
            myPair.max = right.max;
        }else{
            myPair.max = root.val;
        }
        myPair.isBST = true;
        return myPair;
    }
}