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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return helper(preorder,inorder,0,inorder.length-1,0,inorder.length-1);
    }
    
     public TreeNode helper(int[] preorder, int[] inorder, int ps, int pe , int is, int ie) {
         if(ps>pe || is>ie){
             return null;
         }
         TreeNode root = new TreeNode(preorder[ps]);
         int idx = search(inorder,preorder[ps],is,ie);
         int noe = idx-is;
         root.left = helper(preorder,inorder,ps+1,ps+noe,is,idx-1);
         root.right = helper(preorder,inorder,ps+noe+1,pe,idx+1,ie);
         
         return root;
    }
    
    public int search(int[] inorder, int val,int i, int j){
        
        while(i<=j){
            if(inorder[i]==val){
                return i;
            }
            i++;
        }
        return -1;
    }
}