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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length+1,new ListComparator());
        
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                 pq.add(lists[i]);
            }
        }
        ListNode ans = null;
        ListNode i = null;
        while(pq.size()>0){
            ListNode node = pq.poll();
            if(node.next != null){
                pq.add(node.next);
            }
            if(ans==null){
                ans = node;
                i=ans;
            }else{
                i.next=node;
                i=i.next;
            }
            
        }
        return ans;
    }
}

class ListComparator implements Comparator<ListNode> {
    
    public int compare(ListNode l1, ListNode l2){
        if(l1.val < l2.val){
            return -1;
        }else if(l1.val>l2.val){
            return 1;
        }else {
            return 0;
        }
    }
}