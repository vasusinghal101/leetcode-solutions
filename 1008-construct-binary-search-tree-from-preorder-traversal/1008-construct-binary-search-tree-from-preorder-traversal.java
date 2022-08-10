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
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = preorder.clone();
        Arrays.sort(inorder);
        
        return bt(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    
    public TreeNode bt(int[] preorder, int[] inorder, int ps,int pe, int is, int ie){
        if(ps>pe || is>ie || is<0 || ps<0 || ie>=inorder.length || pe>=preorder.length){
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        int idx = find(inorder, is, ie, preorder[ps]);
        int count = idx - is;
        
        root.left = bt(preorder, inorder, ps+1, ps+count, is, idx-1);
        root.right = bt(preorder, inorder, ps+count+1, pe, idx+1, ie);
        
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