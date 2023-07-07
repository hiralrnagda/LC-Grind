/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // Approach 1: TC - O(n) ; SC - O(n)
    // public Node copyRandomList(Node head) {
    // Map<Node, Node> map = new HashMap();
    // Node current = head;
    // while(current != null)
    // {
    // map.put(current, new Node(current.val));
    // current = current.next;
    // }

    // current = head;
    // while(current != null)
    // {
    // map.get(current).next = map.get(current.next);
    // map.get(current).random = map.get(current.random);
    // current = current.next;
    // }

    // return map.get(head);
    // }

    // Approach 2 - TC - O(n) ; SC - O(1)
    public Node copyRandomList(Node head) {
        Node iter = head, front = head;
        while (iter != null) {
            front = iter.next;
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = front;
            iter = front;
        }

        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        iter = head;
        Node dummy = new Node(0);
        Node copy = dummy;
        while (iter != null) {
            front = iter.next.next;
            copy.next = iter.next;
            iter.next = front;
            copy = copy.next;
            iter = iter.next;
        }

        return dummy.next;
    }
}