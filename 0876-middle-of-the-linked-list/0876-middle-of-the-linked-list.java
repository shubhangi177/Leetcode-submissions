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
    public ListNode middleNode(ListNode head) {
        // 'slow' moves one node at a time.
        ListNode slow = head;
        
        // 'fast' moves two nodes at a time.
        ListNode fast = head;
        
        // Continue until 'fast' reaches the end of the list.
        //
        // We check:
        // 1. fast != null      -> so we can safely access fast.next
        // 2. fast.next != null -> so we can safely access fast.next.next
        //
        // Using && ensures short-circuit evaluation.
        // If 'fast' is null, Java will NOT evaluate fast.next,
        // preventing a NullPointerException.
        while (fast != null && fast.next != null) {
        
            // Move 'slow' one step forward.
            slow = slow.next;
        
            // Move 'fast' two steps forward.
            fast = fast.next.next;
        }
        
        // When the loop ends,
        // 'slow' points to the middle node of the linked list.
        return slow;
    }
}