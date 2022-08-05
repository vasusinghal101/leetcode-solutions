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
      public int sumNumbers(TreeNode root) {
    return sumNodes(root, 0);
  }

  private int sumNodes(TreeNode root, int currentSum) {
    if (root == null) return 0;
    currentSum = currentSum * 10 + root.val;
    if (root.left == null && root.right == null) return currentSum;
    int leftSum = sumNodes(root.left, currentSum);
    int rightSum = sumNodes(root.right, currentSum);
    return leftSum + rightSum;
  }
//     public int sumNumbers(TreeNode root) {
//         List<String> ans = new ArrayList<>();
//         helper(root,new StringBuilder() , ans);
//         int sum = 0;
//         for(String str : ans){
//             sum+= Integer.parseInt(str);
//         }
//         return sum;
//     }
    
//     public void helper(TreeNode root, StringBuilder psf, List<String> ans){
//         if(root == null) return;
        
//         int len = psf.length();
//         psf.append(root.val);
//         if(root.left == null && root.right == null){
//             ans.add(psf.toString());
//         }else{
//             helper(root.left, psf, ans);
//             helper(root.right, psf, ans);
//         }
//         psf.setLength(len);
//     }
}