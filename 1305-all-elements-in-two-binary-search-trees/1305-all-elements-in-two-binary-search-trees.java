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
        
        Pair(TreeNode node,int state){
            this.node = node;
            this.state = state;
        }
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        Stack<Pair> st1 = new Stack<>();
        if(root1!=null) st1.push(new Pair(root1,0));
        Stack<Pair> st2 = new Stack<>();
        if(root2!=null) st2.push(new Pair(root2,0));
        Integer val1 = BstIterator(st1);
        Integer val2 = BstIterator(st2);
        
        while(val1!=null && val2!=null){
            if(val1>val2){
                ans.add(val2);
                val2=BstIterator(st2);
            }else{
                ans.add(val1);
                val1 = BstIterator(st1);
            }
        }
        
        if(val1!=null){
            while(val1!=null){
                ans.add(val1);
                val1 = BstIterator(st1); 
            }
        }
        if(val2!=null){
            while(val2!=null){
                ans.add(val2);
                val2 = BstIterator(st2); 
            }
        }       
        return ans;
    }
    
    public Integer BstIterator(Stack<Pair> st){
        while(st.size()>0){
            Pair top = st.peek();
            
            if(top.state == 0){
                if(top.node.left !=null) st.push(new Pair(top.node.left,0));
                top.state++;
            }else if(top.state == 1){
                if(top.node.right !=null) st.push(new Pair(top.node.right,0));
                top.state++;
                return top.node.val;
            }else{
                st.pop();
            }
        }
        
        return null;
    }
}