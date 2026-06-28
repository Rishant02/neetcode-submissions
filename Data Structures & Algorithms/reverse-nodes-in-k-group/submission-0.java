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
    public ListNode reverseKGroup(ListNode head, int k) {

        // Nothing to reverse
        if (head == null || k == 1) {
            return head;
        }

        // Dummy helps handle cases where the first group is reversed
        ListNode dummy = new ListNode(0, head);

        // Points to the node BEFORE the current group
        ListNode groupPrev = dummy;

        while (true) {

            // Find the kth node from groupPrev
            // If fewer than k nodes remain, we're done
            ListNode kth = getKthNode(groupPrev, k);
            if (kth == null) {
                break;
            }

            // Node immediately after the current group
            // Used as a stopping point during reversal
            ListNode groupNext = kth.next;

            /*
             * Reverse:
             * groupPrev -> 1 -> 2 -> 3 -> groupNext
             *
             * becomes:
             * groupPrev -> 3 -> 2 -> 1 -> groupNext
             */
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next; // first node of current group

            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            /*
             * Before reversal:
             * groupPrev -> 1 -> 2 -> 3
             *
             * After reversal:
             * groupPrev -> ?    3 -> 2 -> 1
             *
             * Need to reconnect groupPrev to new head (kth = 3)
             */

            // Save old group start (1)
            // It becomes the tail after reversal
            ListNode tmp = groupPrev.next;

            // Connect previous part to new group head
            groupPrev.next = kth;

            // Move groupPrev to tail of reversed group
            // Next iteration starts from here
            groupPrev = tmp;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k) {

        // Move k steps ahead
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }

        // Returns kth node if it exists,
        // otherwise null
        return curr;
    }
}
