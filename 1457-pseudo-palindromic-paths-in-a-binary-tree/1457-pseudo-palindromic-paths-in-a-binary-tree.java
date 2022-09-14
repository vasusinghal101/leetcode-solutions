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
    public int pseudoPalindromicPaths (TreeNode root) {
        return pseudoPalindromicPaths(root, new HashMap<Integer, Integer>());
    }
    public int pseudoPalindromicPaths (TreeNode root, HashMap<Integer, Integer> fmap) {
        int n = root.val;
        fmap.put(n, fmap.getOrDefault(n,0)+1);
        int ans = 0;
        if(root.left == null && root.right == null){
            ans = isPalindrome(fmap) ? 1 : 0;
        }else{
            if(root.left != null) ans += pseudoPalindromicPaths(root.left, fmap);
            if(root.right != null) ans += pseudoPalindromicPaths(root.right, fmap);
        }
        fmap.put(n, fmap.getOrDefault(n,0)-1);
        return ans;
    }
    
    public boolean isPalindrome(HashMap<Integer, Integer> fmap){
        boolean gotOdd= false;
        for(int key : fmap.keySet()){
            int freq = fmap.get(key);
            if(freq%2!=0){
                if(gotOdd)return false;
                else gotOdd= true;
            }
        }
        return true;
    }
    
    // public boolean isPalindrome(ArrayList<Integer> arr){
    //     HashMap<Integer, Integer> fmap = new HashMap<>();
    //     for(int n : arr) fmap.put(n, fmap.getOrDefault(n,0)+1);
    //     boolean gotOdd= false;
    //     for(int key : fmap.keySet()){
    //         int freq = fmap.get(key);
    //         if(freq%2!=0){
    //             if(gotOdd)return false;
    //             else gotOdd= true;
    //         }
    //     }
    //     return true;
    // }
}