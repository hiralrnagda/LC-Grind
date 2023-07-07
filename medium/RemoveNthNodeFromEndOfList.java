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
// class Solution {
//     //Approach 1: 2 loops O(2N)
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         //find length of the list
//         int length = 0;
//         ListNode current = head;
//         while(current != null)
//         {
//             current = current.next;
//             length++;
//         }

//         //if 1st node is to removed
//         if(length == n){
//             return head.next;
//         }

//         //find node to be removed -> index = length - n - 1
//         int nodeBeforeRemovedIndex = length - n - 1;
//         current = head;

//         for(int i = 0; i < nodeBeforeRemovedIndex; i++){
//             current = current.next;
//         }

//         current.next = current.next.next;

//         return head;   
//     }
// }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //move current node n steps into the list 
        ListNode current = head;
        for(int i = 0; i < n; i++){
            current = current.next;
        }

        //if 1st node is to be removed - current will be pointing null
        if(current == null) return head.next;

        //move both pointers until current reaches end of the list
        ListNode nodeBeforeRemoved = head;
        while(current.next != null){
            current = current.next;
            nodeBeforeRemoved = nodeBeforeRemoved.next;
        }
        nodeBeforeRemoved.next = nodeBeforeRemoved.next.next;

        return head;   
    }
}