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
        // TC: O(3n), SC: O(1)
        head = reverse(head);

        if(n == 1){
            head = head.next;
            return reverse(head);
        }

        ListNode curr = head;
        // stop one node before target node
        for(int i = 1; i < n - 1; i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return reverse(head);
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
