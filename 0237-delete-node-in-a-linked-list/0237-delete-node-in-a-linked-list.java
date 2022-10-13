/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode f=node;
        while(f.next.next!=null){
            f.val=f.next.val;
            f=f.next;
        }
        f.val=f.next.val;
        f.next=null;
        return;
    }
}