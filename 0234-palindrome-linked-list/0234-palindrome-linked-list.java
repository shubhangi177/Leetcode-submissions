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
    public boolean isPalindrome(ListNode head) {

        // 'slow' moves one step at a time.
        // 'fast' moves two steps at a time.
        ListNode slow = head;
        ListNode fast = head;

        // Find the middle of the linked list.
        //
        // We check:
        // 1. fast != null      -> so we can safely access fast.next
        // 2. fast.next != null -> so we can safely access fast.next.next
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse the second half of the linked list.
        ListNode prev = null;
        ListNode next = null;

        while (slow != null) {

            // Save the next node before changing any links.
            next = slow.next;

            // Reverse the current node's pointer.
            slow.next = prev;

            // Move 'prev' one step forward.
            prev = slow;

            // Move 'slow' to the next node.
            slow = next;
        }

        // 'first' starts from the beginning of the list.
        ListNode first = head;

        // 'second' starts from the head of the reversed second half.
        ListNode second = prev;

        // Compare both halves node by node.
        //
        // We only check second != null because:
        // - The second half is never longer than the first half.
        // - Therefore, if 'second' exists, 'first' is guaranteed to exist.
        while (second != null) {

            // If any pair of values is different,
            // the linked list is not a palindrome.
            if (first.val != second.val) {
                return false;
            }

            // Move both pointers forward.
            first = first.next;
            second = second.next;
        }

        // All corresponding nodes matched.
        return true;
    }
}