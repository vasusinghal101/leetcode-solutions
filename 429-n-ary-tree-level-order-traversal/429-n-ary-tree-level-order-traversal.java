/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        Queue<Node> q = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root!=null) q.add(root);
        
        while(q.size()>0){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<size; i++){
                Node front = q.remove();
                level.add(front.val);
                for(Node n : front.children){
                    q.add(n);
                }
                
            }
            ans.add(level);
        }
        return ans;
        
    }
}