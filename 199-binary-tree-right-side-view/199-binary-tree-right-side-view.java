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
//     public List<Integer> rightSideView(TreeNode root) {
//         if (root == null)
//             return new ArrayList();
        
//         List<Integer> ans = new ArrayList<Integer>();
        
//         LinkedList<TreeNode> q = new LinkedList<>();
        
//         q.addLast(root);
        
//         while(q.size()>0){
//             int s = q.size();
//             boolean flag=false;
//             while(s-- > 0){
//                TreeNode r = q.removeFirst();
//                 if(!flag){
//                     ans.add(r.val);
//                     flag=true;
//                 }
//                 if(r.right!=null)
//                  q.addLast(r.right);
//                  if(r.left!=null)
//                  q.addLast(r.left);
//             }            
            
//         }
        
//         return ans;
//     }
public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList();
        
        List<Integer> ans = new ArrayList<Integer>();
        
        LinkedList<TreeNode> q = new LinkedList<>();
        
        q.addLast(root);
        
        while(q.size()>0){
            int s = q.size();
            while(s-- > 0){
               TreeNode r = q.removeFirst();
                if(s == 0)
                    ans.add(r.val);

                if(r.left!=null)
                 q.addLast(r.left);
                if(r.right!=null)
                 q.addLast(r.right);
            }            
        }
        return ans;
    }
}