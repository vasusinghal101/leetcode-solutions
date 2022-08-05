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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root,new StringBuilder() , ans);
        return ans;
    }
    
    public void helper(TreeNode root, StringBuilder psf, List<String> ans){
        if(root == null) return;
        
        int len = psf.length();
        psf.append(root.val);
        if(root.left == null && root.right == null){
            ans.add(psf.toString());
        }else{
            psf.append("->");
            helper(root.left, psf, ans);
            helper(root.right, psf, ans);
        }
        psf.setLength(len);
    }
}