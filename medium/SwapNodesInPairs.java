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
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode node = dummy;
        
        while(node != null){
            ListNode first = node.next;
            ListNode second = null;
            if(first != null) 
                second = first.next;

            if(second != null){
                ListNode secondNext = second.next;
                second.next = first;
                node.next = second;
                first.next = secondNext;
                node = first;
            }
            else {
                break;
            }

        }
        return dummy.next;
    }
}