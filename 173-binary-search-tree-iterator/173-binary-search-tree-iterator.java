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
class BSTIterator {
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
    Stack<Pair> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        if(root!=null) st.push(new Pair(root, 0));
        
    }
    public int next() {
         while(st.size()>0){
            Pair top = st.peek();
            if(top.state == 0){
                if(top.node.left!=null) st.push(new Pair(top.node.left,0));
                top.state++;
            }else if(top.state == 1){
                st.pop();
                if(top.node.right!=null){
                    st.push(new Pair(top.node.right,0));
                }
                return top.node.val;
            }
        }
        return 0;
    }
    
    public boolean hasNext() {
        return st.size() != 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */