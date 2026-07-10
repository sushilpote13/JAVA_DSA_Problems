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
        int count = 0;
        ListNode temp = head;

        // Count nodes
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Move to middle
        temp = head;
        for (int i = 0; i < count / 2; i++) {
            temp = temp.next;
        }

        return temp;
    }
}