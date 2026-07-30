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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {
                // Delete the node.
                curr.next = curr.next.next;

                // Don't move curr.
                // The new curr.next might also need to be deleted.
            } else {
                // Safe to move forward.
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}