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
        // Dummy node handles edge cases such as removing the head node.
        ListNode dummy = new ListNode(-1, head);

        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast ahead by (n + 1) nodes.
        // This creates a fixed gap of n nodes between slow and fast.
        // Example:
        // List: 1 -> 2 -> 3 -> 4 -> 5, n = 2
        // After this loop:
        // slow = dummy
        // fast = 3
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers together while maintaining the gap.
        // When fast reaches null:
        // - slow will be exactly one node BEFORE the node to delete.
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node from the end.
        // Since slow is right before the target node,
        // skip it by rewiring the next pointer.
        slow.next = slow.next.next;

        return dummy.next;
    }
}
