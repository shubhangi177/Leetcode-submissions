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

        // 'curr' is used to traverse the original list.
        ListNode curr = head;

        // 'prev' stores the previous node.
        // Initially null because the new tail will point to null.
        ListNode prev = null;

        // 'next' temporarily stores the next node
        // so we don't lose the remaining list after reversing the link.
        ListNode next = null;

        // Traverse until all nodes are processed.
        while (curr != null) {

            // Step 1: Save the next node before changing any links.
            next = curr.next;

            // Step 2: Reverse the current node's pointer.
            curr.next = prev;

            // Step 3: Move 'prev' one step forward.
            // It now becomes the new head of the reversed part.
            prev = curr;

            // Step 4: Move 'curr' to the next node
            // to continue reversing the remaining list.
            curr = next;
        }

        // When the loop ends:
        // curr = null
        // prev points to the new head of the reversed list.
        return prev;
    }
}