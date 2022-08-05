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
    public int widthOfBinaryTree(TreeNode root) {
        HashMap<Integer, Integer> low= new HashMap<>();
        HashMap<Integer, Integer> high= new HashMap<>();
    
        helper(root,0,0,low,high);
        
        int ans = 0;
        for(int row : low.keySet()){
            ans=Math.max(ans, high.get(row) - low.get(row));
        }
        
        return ans+1;
    }
    
    public void helper(TreeNode root, int row, int col, HashMap<Integer, Integer> low, HashMap<Integer, Integer> high){
        if(root==null) return;
        
        if(!low.containsKey(row)){
            low.put(row,col);
            high.put(row,col);
        }else{
            if(col<low.get(row)) low.put(row, col);
            if(col>high.get(row)) high.put(row,col);
        }
        helper(root.left, row+1, (2*col)+1,low,high);
        helper(root.right, row+1, (2*col)+2,low,high);
    }
}