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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            int size = q.size();
            double sum=0;
            for(int i = 0; i<size;i++){
                TreeNode n = q.remove();
                sum+=n.val;
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
            }
            ans.add(sum/size);
        }
        
        return ans;
    }
}