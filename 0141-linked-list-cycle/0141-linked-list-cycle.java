/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * Floyd's Cycle Detection Algorithm (Tortoise and Hare)
 *
 * Idea:
 * - 'slow' moves one step at a time.
 * - 'fast' moves two steps at a time.
 * - If a cycle exists, both pointers will eventually
 *   meet at the same node.
 * - If 'fast' reaches the end (null), there is no cycle.
 */

class Solution {
    public boolean hasCycle(ListNode head) {

        // 'slow' moves one node at a time.
        ListNode slow = head;

        // 'fast' moves two nodes at a time.
        ListNode fast = head;

        // Continue until 'fast' reaches the end.
        //
        // We check:
        // 1. fast != null      -> so we can safely access fast.next
        // 2. fast.next != null -> so we can safely access fast.next.next
        //
        // Using && prevents a NullPointerException due to
        // Java's short-circuit evaluation.
        while (fast != null && fast.next != null) {

            // Move 'slow' one step.
            slow = slow.next;

            // Move 'fast' two steps.
            fast = fast.next.next;

            // IMPORTANT:
            // Compare the nodes themselves, NOT their values.
            //
            // Wrong:  fast.val == slow.val
            // Different nodes can store the same value.
            //
            // Correct: fast == slow
            // This checks whether both pointers refer to
            // the exact same node in memory.
            if (fast == slow) {
                return true;
            }
        }

        // 'fast' reached the end of the list,
        // so no cycle exists.
        return false;
    }
}