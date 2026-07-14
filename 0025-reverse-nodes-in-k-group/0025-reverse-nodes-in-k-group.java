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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;
        // frist part of code is to group the k nodes 
        while (count < k) {
            if (temp == null) {
                return head;
            }
            temp = temp.next;
            count++;
        }
        // Second part is to call the recursive call for rest of k nodes
        ListNode prev = reverseKGroup(temp, k);

        // Now the main last step is to reverse the k nodes
        temp = head;
        count = 0;
        while (count < k) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
            count++;
        }
        return prev;
    }
}