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
    public Node copyRandomList(Node head) {
        // Edge case: empty list
        if (head == null) {
            return null;
        }

        // Map<original node, copied node>
        // This lets us quickly find the copy corresponding to any original node.
        Map<Node, Node> map = new HashMap<>();

        // PASS 1:
        // Create all copied nodes and store the mapping.
        // Don't connect pointers yet because some target nodes
        // may not have been copied yet.
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // PASS 2:
        // Use the mapping to wire up next and random pointers.
        // For any original node:
        //    original.next   -> map.get(original.next)
        //    original.random -> map.get(original.random)
        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);

            copy.next = map.get(curr.next);       // copy of next node
            copy.random = map.get(curr.random);  // copy of random node

            curr = curr.next;
        }

        // Return the copy corresponding to the original head.
        return map.get(head);
    }
}
