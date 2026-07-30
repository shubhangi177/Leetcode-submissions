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
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast= fast.next.next;
            slow = slow.next;
        }

        ListNode prev = null;
        ListNode next = null;
        while(slow!=null){
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode first = head;
        ListNode second = prev;
        while(second!=null){
            if(first.val!=second.val) return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }
}