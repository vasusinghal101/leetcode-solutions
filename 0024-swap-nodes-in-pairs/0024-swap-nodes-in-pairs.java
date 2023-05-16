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
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode node = head;
        if(node.next!=null)
            head=node.next;
        while(node != null && node.next != null){
            ListNode temp = node.next;
            node.next = temp.next;
            temp.next = node;
            temp=node;
            node=node.next;
            if(node != null && node.next!=null)
            temp.next=node.next;
            //System.out.println(node.val+ " "+ temp.val);
        }
        
        return head;
    }
}