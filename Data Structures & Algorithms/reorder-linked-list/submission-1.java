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
    public void reorderList(ListNode head) {
        /*
         * Goal:
         * L0 -> L1 -> L2 -> ... -> Ln
         *
         * becomes
         *
         * L0 -> Ln -> L1 -> Ln-1 -> L2 -> ...
         *
         * Approach:
         * 1. Find the middle of the list.
         * 2. Reverse the second half.
         * 3. Merge both halves alternately.
         *
         * TC: O(n)
         * SC: O(1)
         */

        if (head == null || head.next == null) {
            return;
        }

        // Find middle using fast/slow pointers.
        // When fast reaches the end, slow is at the middle.
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        /*
         * Example:
         * 1 -> 2 -> 3 -> 4 -> 5
         *           ^
         *         slow
         *
         * First half : 1 -> 2 -> 3
         * Second half: 4 -> 5
         */

        // Reverse the second half so that we can
        // take nodes from the end in O(1) time.
        ListNode second = reverseList(slow.next);

        // Disconnect first half from second half.
        slow.next = null;

        /*
         * First half : 1 -> 2 -> 3
         * Reversed second: 5 -> 4
         */

        ListNode first = head;

        // Merge both lists alternately.
        while (second != null) {

            // Save next pointers before rewiring.
            ListNode fNode = first.next;
            ListNode bNode = second.next;

            /*
             * Insert second between first and fNode.
             *
             * Before:
             * first -> fNode
             * second -> bNode
             *
             * After:
             * first -> second -> fNode
             */
            first.next = second;
            second.next = fNode;

            // Move both pointers forward.
            first = fNode;
            second = bNode;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        // prev becomes the new head.
        return prev;
    }
}
