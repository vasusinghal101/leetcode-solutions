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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Queue<TreeNode> q = new ArrayDeque<>();
        
        if(root!=null){
            q.add(root);
        }
        boolean reverse = false;
        while(q.size()>0){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode front = q.remove();
                if(front.left!=null){
                    q.add(front.left);
                }
                if(front.right!=null){
                    q.add(front.right);
                }
                level.add(front.val);
            }
            if(reverse) Collections.reverse(level);
            reverse = !reverse;
            ans.add(level);
        }
        
        return ans;
    }
}