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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null){
           List<List<Integer>> ans = new ArrayList<>();
           return ans; 
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> qt = new LinkedList<>();
        List<Integer> aa = new ArrayList<>();
        aa.add(root.val);
        ans.add(aa);
        q.add(root);
        while(q.size()>0||qt.size()>0){
            List<Integer> a = new ArrayList<>();
            while(q.size()>0){
                TreeNode node = q.remove();
                if(node.left!=null){
                    qt.add(node.left);
                    a.add(node.left.val);
                }
                if(node.right!=null){
                    qt.add(node.right);
                    a.add(node.right.val);
                }
            }
            if(a.size()>0)
            ans.add(a);
            q=qt;
            qt = new LinkedList<>();
//             while(qt.size()>0){
//                 TreeNode node=
                
//             }
        }
        Collections.reverse(ans);
        return ans;
        
    }
}