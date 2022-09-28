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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = new ListNode();
        prev.next = head;
        ListNode curr = head;
        int gap = 1;
        while(gap<n && curr!=null){//n greater then no. of elements)
            curr = curr.next;
            gap++;
        }
        
        while(curr.next != null){
            prev = prev.next;
            curr = curr.next;
        }
        
        if(prev.next==head) return head.next;//can be avoided see soln;
        
        prev.next = prev.next.next;
        return head;
    }
}