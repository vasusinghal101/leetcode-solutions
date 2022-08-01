/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    
    public Node bfs(Node root){
        if (root == null) {
            return root;
        }
        
        // Initialize a queue data structure which contains
        // just the root of the tree
        Queue<Node> Q = new LinkedList<Node>(); 
        Q.add(root);
        
        // Outer while loop which iterates over 
        // each level
        while (Q.size() > 0) {
            
            // Note the size of the queue
            int size = Q.size();
            
            // Iterate over all the nodes on the current level
            for(int i = 0; i < size; i++) {
                // Pop a node from the front of the queue
                Node node = Q.poll();
                // This check is important. We don't want to
                // establish any wrong connections. The queue will
                // contain nodes from 2 levels at most at any
                // point in time. This check ensures we only 
                // don't establish next pointers beyond the end
                // of a level
                if (i < size - 1) {
                    node.next = Q.peek();
                } 
                // Add the children, if any, to the back of
                // the queue
                if (node.left != null) {
                    Q.add(node.left);
                }
                if (node.right != null) {
                    Q.add(node.right);
                }
            }
        }
        // Since the tree has now been modified, return the root node
        return root;
    }
    
    public Node connect(Node root) {
        Node curr = root;
        
        while(curr!=null){
            Node head=null, tail = null;
            
            while(curr != null){
                if(curr.left!=null){
                    if(head == null){
                        head=tail=curr.left;
                    }else{
                        tail.next = curr.left;
                        tail = tail.next;
                    }
                }
                if(curr.right!=null){
                     if(head == null){
                        head=tail=curr.right;
                    }else{
                         tail.next = curr.right;
                         tail = tail.next;
                     }
                }
                curr = curr.next;
            }
            curr = head;
        }
        return root;
    }
}