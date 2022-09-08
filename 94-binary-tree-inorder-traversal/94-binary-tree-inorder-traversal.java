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
//     public List<Integer> inorderTraversal(TreeNode root) {
//         if(root==null){
//             return new ArrayList<Integer>();
//         }
        
//         List<Integer> l = inorderTraversal(root.left);
//         l.add(root.val);
//         List<Integer> r = inorderTraversal(root.right);
        
//            l.addAll(r);
//            return l;
//     }
    class Pair{
        TreeNode node;
        int state;
        
        Pair(TreeNode node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        
        if(root==null) return ans;
        
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 0));
        
        while(st.size()>0){
            Pair p = st.peek();
            if(p.state==0){//preoOrder
                if(p.node.left!= null) st.push(new Pair(p.node.left, 0));
                p.state++;
            }else if(p.state == 1){//inorder
                ans.add(p.node.val);
                if(p.node.right != null) st.push(new Pair(p.node.right, 0));
                p.state++;
            }else{//postorder
                st.pop();
            }
        }
        
        return ans;
}}