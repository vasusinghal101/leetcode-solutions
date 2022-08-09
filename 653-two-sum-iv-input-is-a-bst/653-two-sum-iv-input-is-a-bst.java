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
    class Pair{
        TreeNode node;
        int state;
        //state 0-> Not processed yet(preorder), 1->second time(left processed, Inorder),
        //2-> right processed (post order)
        Pair(TreeNode root, int state){
            this.node = root;
            this.state = state;
        }
    }
    public Integer BstIterator(Stack<Pair> st){
        
        while(st.size()>0){
            Pair top = st.peek();
            if(top.state == 0){
                if(top.node.left!=null) st.push(new Pair(top.node.left,0));
                top.state++;
            }else if(top.state == 1){
                if(top.node.right!=null) st.push(new Pair(top.node.right,0));
                top.state++;
                return top.node.val;
            }else{
                st.pop();
            }
        }
        
        return null;
    }

    public Integer BstIteratorRight(Stack<Pair> st){
        
        while(st.size()>0){
            Pair top = st.peek();
            if(top.state == 1){
                if(top.node.left!=null) st.push(new Pair(top.node.left,0));
                top.state++;
                return top.node.val;
            }else if(top.state == 0){
                if(top.node.right!=null) st.push(new Pair(top.node.right,0));
                top.state++;
            }else{
                st.pop();
            }
        }
        
        return null;
    }
    public boolean findTarget(TreeNode root, int k) {
        Stack<Pair> st = new Stack<>();
        if(root!=null) st.push(new Pair(root, 0));
        
        Integer left = BstIterator(st);
        
        Stack<Pair> stR = new Stack<>();
        if(root!=null) stR.push(new Pair(root, 0));
        
        Integer right = BstIteratorRight(stR);
        
        while(left<right){
            int sum = left + right;
            System.out.print(left + " " + right);
            if(sum>k){
                right = BstIteratorRight(stR);
            }else if(sum<k){
                left = BstIterator(st);
            }else{
                return true;
            }
        }
        
        return false;
    }
}