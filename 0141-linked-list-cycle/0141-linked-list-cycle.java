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

public class Solution {
    public boolean hasCycle(ListNode head) {

        // Empty list or single node cannot have a cycle
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;          // Move 1 step
            fast = fast.next.next;     // Move 2 steps

            // If both pointers meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // Fast reached the end, so no cycle
        return false;
    }
}