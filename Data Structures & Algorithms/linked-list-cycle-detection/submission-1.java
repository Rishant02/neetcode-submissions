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
    public boolean hasCycle(ListNode head) {
        // tortoise & hare algo
        // TC: O(n), SC: O(n)
        Set<ListNode> visited = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (visited.contains(current))
                return true;
            visited.add(current);
            current = current.next;
        }
        return false;
    }
}
