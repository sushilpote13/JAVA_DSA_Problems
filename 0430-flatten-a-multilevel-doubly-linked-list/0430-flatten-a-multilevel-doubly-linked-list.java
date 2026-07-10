/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        dfs(head);
        return head;
    }
    private Node dfs(Node curr) {
        Node current = curr;
        Node last = null;
        while (current != null) {
            Node next = current.next;
            if (current.child == null) {
                last = current;
                current = next;
            }
            else {
                Node childHead = current.child;
                Node childTail = dfs(childHead);
                current.next = childHead;
                childHead.prev = current;
                current.child = null;
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }
                last = childTail;
                current = next;
            }
        }
        return last;
    }
}