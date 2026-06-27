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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node helps simplify list construction.
        // The actual answer starts from dummy.next.
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Stores carry generated from previous digit addition.
        int carry = 0;

        // Continue while:
        // 1. l1 still has digits
        // 2. l2 still has digits
        // 3. there is a leftover carry
        while (l1 != null || l2 != null || carry != 0) {
            // Start with carry from previous iteration.
            int sum = carry;

            // Add current digit from l1 if available.
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add current digit from l2 if available.
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Ones place becomes the new node value.
            tail.next = new ListNode(sum % 10);

            // Tens place becomes carry for next iteration.
            carry = sum / 10;

            // Move tail forward.
            tail = tail.next;
        }

        // Skip dummy and return actual result list.
        return dummy.next;
    }
}
