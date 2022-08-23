/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        
        ListNode m = mid(head);
        ListNode nh = reverse(m);
        
        while(head!=m){
            if(head.val!=nh.val) return false;
            head = head.next;
            nh = nh.next;
        }
        
        return true;
    }
    
    public ListNode mid(ListNode head){
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        
        ListNode ph = null;
        while(head!=null){
            ListNode p = head.next;
            head.next = ph;
            ph = head;
            head = p;  
        }
        
        return ph;
       
    }
}