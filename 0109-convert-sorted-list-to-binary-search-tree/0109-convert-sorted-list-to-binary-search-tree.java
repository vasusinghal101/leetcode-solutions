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
public class Solution {
public TreeNode sortedListToBST(ListNode head) {
   return sortedListToBST(head, null);
}
private TreeNode sortedListToBST(ListNode head, ListNode tail){
    if(head == null || head == tail)
        return null;
    if(head.next == tail)
        return new TreeNode(head.val);
    ListNode fast = head, slow = head;
    while(fast!=tail && fast.next!=tail){
        fast = fast.next.next;
        slow = slow.next;
    }
    TreeNode root = new TreeNode(slow.val);
    root.left = sortedListToBST(head, slow);
    root.right = sortedListToBST(slow.next, tail);
    return root;
}
}