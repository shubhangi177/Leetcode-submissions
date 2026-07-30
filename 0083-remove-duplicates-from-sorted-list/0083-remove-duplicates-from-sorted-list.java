/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        // 'curr' is used to traverse the linked list.
        // 'head' is kept unchanged so it can be returned at the end.
        ListNode curr = head;

        // Continue until 'curr' reaches the end
        // or there is no next node to compare.
        //
        // We check:
        // 1. curr != null      -> so we can safely access curr.val
        // 2. curr.next != null -> so we can safely access curr.next.val
        while (curr != null && curr.next != null) {

            // If the current node and the next node
            // have the same value, a duplicate is found.
            if (curr.val == curr.next.val) {

                // Remove the duplicate node by skipping it.
                // curr stays at the same node because there
                // might be more consecutive duplicates.
                //
                // Example:
                // 1 -> 1 -> 1 -> 2
                // After one deletion:
                // 1 -> 1 -> 2
                // We must compare again with the new curr.next.
                curr.next = curr.next.next;

            } else {

                // No duplicate found.
                // Move to the next node.
                curr = curr.next;
            }
        }

        // 'head' still points to the beginning of the list
        // because only 'curr' was used for traversal.
        return head;
    }
}