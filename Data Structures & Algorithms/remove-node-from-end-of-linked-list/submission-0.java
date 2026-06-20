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
        // TC: O(n), SC: O(n)
        List<Integer> list = linkedListToList(head);
        ListNode dummy = new ListNode(-1);

        ListNode current = dummy;
        for(int i = 0; i < list.size(); i++){
            if(list.size() - n != i){
                current.next = new ListNode(list.get(i));
                current = current.next;
            }
        }

        return dummy.next;
    }

    private List<Integer> linkedListToList(ListNode head){
        List<Integer> result = new ArrayList<>();
        ListNode current = head;

        while(current != null){
            result.add(current.val);
            current = current.next;
        }

        return result;
    }
}
