/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {//Check solution also graph bfs can be used first get mapping of all parent .Now start BFS from target till we reach k level. each node three neighbours.
    
    public boolean path(TreeNode root, TreeNode target, List<TreeNode> r2n){
        if(root==null) return false;
        
        if(root == target){
            r2n.add(root);
            return true;
        }
        
        r2n.add(root);
        if(path(root.left,target,r2n)) return true;
        if(path(root.right,target,r2n)) return true;
        
        r2n.remove(r2n.size()-1);
        return false;
    }
    
    public void kLevelDown(TreeNode root, TreeNode blocker, int k, List<Integer> ans){
        if(root == null || root==blocker || k<0) return;
        
        if(k==0){
            ans.add(root.val);
            return;
        }
        kLevelDown(root.left,blocker,k-1,ans);
        kLevelDown(root.right,blocker,k-1,ans);
        
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> r2n = new ArrayList<TreeNode>();
        List<Integer> ans = new ArrayList<>();
        if(!path(root,target,r2n)) return ans;
        
        r2n.add(null);
        
        for(int i = r2n.size()-2;i>=0;i--){
            TreeNode blocker = r2n.get(i+1);
            TreeNode start = r2n.get(i);
            kLevelDown(start, blocker, k, ans);
            k--;
        }
        return ans;
    }
}