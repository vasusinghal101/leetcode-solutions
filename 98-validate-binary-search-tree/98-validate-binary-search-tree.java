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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) 
            return true; 
        if ((max != null && root.val >= max) || (min != null && root.val <= min)) // checking the range if our root is b/w range if there is change
            return false; 
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);// updating he range if left call then max for children can be root
        //if right call min for children can be root
    }
}
// class Solution {
//     class Pair{
//         boolean isBST;
//         int min;
//         int max;
//         Pair(){
//             this.isBST = false;
//             this.min = Integer.MAX_VALUE;
//             this.max = Integer.MIN_VALUE;
//         }
        
//         Pair(boolean isBST, int min, int max){
//             this.isBST = isBST;
//             this.min = min;
//             this.max = max;
//         }
//     }
//     public boolean isValidBST(TreeNode root) {
//         Pair ans = helper(root);
//         return ans.isBST;
//     }
    
//     public Pair helper(TreeNode root){
//         if(root == null) return null;
//         Pair myPair = new Pair();
//         if(root.left!=null){ 
//             Pair left = helper(root.left);
//             if(!left.isBST || left.max >= root.val){
//                 return new Pair();
//             }
//             myPair.min = left.min;
//         }else{
//             myPair.min = root.val;
//         }
        
//         if(root.right!=null){ 
//             Pair right = helper(root.right);        
//             if(!right.isBST || right.min <= root.val){
//                 return new Pair();
//             }
//             myPair.max = right.max;
//         }else{
//             myPair.max = root.val;
//         }
//         myPair.isBST = true;
//         return myPair;
//     }
// }