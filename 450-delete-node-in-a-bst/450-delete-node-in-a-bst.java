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
    public int min(TreeNode root){
        int ans = root.val;
        while(root!=null){
            ans = root.val;
            root = root.left;
        }
        return ans;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        if(root.val>key){
            root.left = deleteNode(root.left, key);
        }else if(root.val<key){
            root.right = deleteNode(root.right, key);
        }else{//found key now delete
            if(root.left == null && root.right == null) return null;//leaf
            else if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else{//in middle with both children
                //get right min replce with me and delete that
                int m = min(root.right);
                root.val = m;
                root.right = deleteNode(root.right,m);
            }
        }
        return root;
    }
}