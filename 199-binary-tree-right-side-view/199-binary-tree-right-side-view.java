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
    public void dfs(TreeNode root, int level, List<Integer> ans) {
         if(root == null)return;
        
         if(level>ans.size())ans.add(root.val);

         dfs(root.right, level+1, ans);
         dfs(root.left, level+1, ans);

    }
public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList();
        
        List<Integer> ans = new ArrayList<Integer>();
        dfs(root,1,ans);
        return ans;
    
        //bfs
//         LinkedList<TreeNode> q = new LinkedList<>();
        
//         q.addLast(root);
        
//         while(q.size()>0){
//             int s = q.size();
//             while(s-- > 0){
//                TreeNode r = q.removeFirst();
//                 if(s == 0)
//                     ans.add(r.val);
//                 if(r.left!=null)
//                  q.addLast(r.left);
//                 if(r.right!=null)
//                  q.addLast(r.right);
//             }            
//         }
//         return ans;
    }
}