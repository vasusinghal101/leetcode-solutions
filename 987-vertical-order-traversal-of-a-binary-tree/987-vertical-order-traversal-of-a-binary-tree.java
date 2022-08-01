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
    public void dfs(TreeNode root,int row, int col, TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> hm){
        if(root == null) return;

        TreeMap<Integer, ArrayList<Integer>> tm = hm.get(col);
        if(tm==null){
            tm = new TreeMap<>();
            hm.put(col, tm);
        }
        ArrayList<Integer> ts = tm.get(row);
        if(ts ==null ){
            ts = new ArrayList<>();
            tm.put(row, ts);
        }
        ts.add(root.val);
        dfs(root.left,row+1, col-1, hm);
        dfs(root.right,row+1, col+1, hm);
        
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();               dfs(root,0,0,map);
        
        List<List<Integer>> ans = new ArrayList<>();

        for(int col : map.keySet()){
            List<Integer> iterm = new ArrayList<Integer>();
            TreeMap<Integer, ArrayList<Integer>> ta = map.get(col);
            for(int row : ta.keySet()){
                ArrayList<Integer> sv = ta.get(row);
                Collections.sort(sv);
                for(int n : sv){
                    iterm.add(n);
                }
            }
            ans.add(iterm);
        }
        
        return ans;
    }
}