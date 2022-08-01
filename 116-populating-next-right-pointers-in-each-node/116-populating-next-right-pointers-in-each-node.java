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
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        
        Node leftMost = root;
        
        while(leftMost!=null){
            
            Node head = leftMost;
            
            while(head != null && head.left!=null){
                head.left.next = head.right;
                head.right.next = head.next == null ? null : head.next.left;
                head = head.next;
            }
            
            leftMost = leftMost.left; 
        }
        
        return root;
    }
}