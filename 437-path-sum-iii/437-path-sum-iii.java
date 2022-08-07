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

//for optimization first check count of sub array sum equal to k 560.
class Solution {
     public int pathSum(TreeNode root, int target) {
        if(root==null) return 0;
         HashMap<Long, Integer> hm = new HashMap<>();
         hm.put(0l,1);
         return helper(root, target, 0, hm);
    }
    public int helper(TreeNode root, long target, long ssf, HashMap<Long, Integer> prefixSums){
        if(root == null) return 0;
        long s = ssf+root.val;
        int ans = 0;
        ans+= prefixSums.getOrDefault((s - target),0);// count ending at me 
        //if(s==18) System.out.print(prefixSums + ""+ans);
        prefixSums.put(s,prefixSums.getOrDefault(s,0)+1);
        ans+= helper(root.left, target, s, prefixSums);
         ans+= helper(root.right, target, s, prefixSums);
        prefixSums.put(s,prefixSums.getOrDefault(s,0)-1);
        return ans;
        
    }
    // public int helper(TreeNode root, long target){
    //     if(root==null) return 0;
    //     int ans=0;
    //     if(target==root.val) ans++;
    //     ans+= helper(root.left, target - root.val);
    //     ans+= helper(root.right, target - root.val);
    //     return ans;
    // }
    // public int pathSum(TreeNode root, int target) {
    //     if(root==null) return 0;
    //     int ans=0;
    //      ans+= helper(root, target);
    //      ans+= pathSum(root.left, target);
    //      ans+= pathSum(root.right, target);
    //     return ans;
    // }
}