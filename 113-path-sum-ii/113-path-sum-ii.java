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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        hasPathSum(root, targetSum, ans, new ArrayList<Integer>());
        return ans;
    }
    public void hasPathSum(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> psf) {
        if(root == null) return ;
        
        psf.add(root.val);
        
        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0){
                ans.add(new ArrayList<Integer>(psf));
            }
        }else{
            hasPathSum(root.left, targetSum-root.val, ans, psf);
            hasPathSum(root.right, targetSum-root.val, ans, psf);
        }
    
        psf.remove(psf.size()-1);
    }
}