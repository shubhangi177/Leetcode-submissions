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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Dummy node acts as a fixed starting point.
        // We return dummy.next because dummy itself is not part of the answer.
        ListNode dummy = new ListNode(-1);

        // 'tail' always points to the last node
        // of the merged list.
        ListNode tail = dummy;

        // Continue until one of the lists becomes empty.
        while (list1 != null && list2 != null) {

            // Compare the values of the current nodes.
            if (list1.val < list2.val) {

                // Attach the smaller node to the merged list.
                // IMPORTANT:
                // Modify tail.next, NOT list1.next or list2.next.
                // We are building the merged list using 'tail'.
                tail.next = list1;

                // Move list1 to its next node.
                list1 = list1.next;
            } else {

                // Attach the smaller node to the merged list.
                // Do NOT write:
                // list2.next = list1;
                // That changes the original list instead of extending
                // the merged list.
                tail.next = list2;

                // Move list2 to its next node.
                list2 = list2.next;
            }

            // Move 'tail' to the last node of the merged list.
            // If you don't move tail, every new node will overwrite
            // the previous connection.
            tail = tail.next;
        }

        // One list has finished.
        // The other list may still contain multiple nodes.
        // Attaching its head automatically attaches the
        // entire remaining linked list.
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        // Return the actual head of the merged list.
        // Don't return tail because it ends at the last node.
        // Don't return list1/list2 because they have already moved.
        return dummy.next;
    }
}