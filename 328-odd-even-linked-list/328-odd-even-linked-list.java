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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = null;
        ListNode even =null;
         ListNode heven =null;
        if(head != null){
            odd = head;
            heven = even = head.next;
        }
        
        while(even != null && even.next !=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            odd.next = null;
            even = even.next;
            
        }
        
        if(head != null) odd.next = heven;
        
        return head;
    }
}