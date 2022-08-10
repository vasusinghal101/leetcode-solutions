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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return bt(postorder, inorder, 0, postorder.length-1, 0 , inorder.length-1);
    }
    
    public TreeNode bt(int[] postorder, int[] inorder, int ps,int pe, int is, int ie){
        if(ps>pe || is>ie || is<0 || ps<0 || ie>=inorder.length || pe>=postorder.length){
            return null;
        }
        TreeNode root = new TreeNode(postorder[pe]);
        int idx = find(inorder, is, ie, postorder[pe]);
        int count = idx - is;
        
        root.left = bt(postorder, inorder, ps, ps+count-1, is, idx-1);
        root.right = bt(postorder, inorder, ps+count, pe-1, idx+1, ie);
        
        return root;
    }
    
    public int find(int[] arr, int l, int h, int val){
        while(l<=h){
            if(arr[l] == val) return l;
            l++;
        }
        System.out.print(h +"wrong"+ val);
        return -1;
    }
}