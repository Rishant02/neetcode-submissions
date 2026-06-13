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
        // TC: O(n), SC: O(n)
        List<Integer> values = new ArrayList<>();
        ListNode curr = head;

        while(curr != null){
            values.add(curr.val);
            curr = curr.next;
        }

        int l = 0, r = values.size() - 1;
        curr = head;

        while(l <= r){
            curr.val = values.get(l++);
            curr = curr.next;

            if(l <= r){
                curr.val = values.get(r--);
                curr = curr.next;
            }
        }
    }
}
