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
    public ListNode reverseList(ListNode head) {
        // TC: O(n), SC: O(n)
        // Base case
        if(head == null || head.next == null) {
            return head;
        }
        // reverse remaining linked list
        ListNode newHead = reverseList(head.next);
        // reverse current link
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
