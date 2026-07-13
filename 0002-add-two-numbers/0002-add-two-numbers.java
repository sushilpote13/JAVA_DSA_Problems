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
    static int carry = 0;

    public static void addNode(ListNode l1, ListNode l2, ListNode curr) {
        int add;
        if (l1 == null && l2 == null) {
            add = carry;
        } else if (l2 == null) {
            add = l1.val + carry;
        } else if (l1 == null) {
            add = l2.val + carry;
        } else {
            add = l1.val + l2.val + carry;
        }
        carry = add / 10;
        add = add % 10;
        curr.val = add;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        while (l1 != null || l2 != null || carry != 0) {
            curr.next = new ListNode();
            curr = curr.next;
            addNode(l1, l2, curr);
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return head.next;
    }
}