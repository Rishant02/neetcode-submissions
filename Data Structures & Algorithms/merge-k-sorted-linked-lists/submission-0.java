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
        if (lists == null || lists.length == 0) {
            return null;
        }
        // TC: O(n * log k), SC: O(k)
        // Min-heap stores the current smallest node from each list
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Initialize heap with all list heads
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Always take the smallest available node
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();

            tail.next = curr;
            tail = curr;

            // Add the next node from the same list
            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }

        return dummy.next;
    }
}
