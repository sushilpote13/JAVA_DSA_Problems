/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        if (node == null) {
            return null;
        }
        Node clone = new Node(node.val);
        map.put(node, clone);
        // for keeping the trak of the node
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            for (Node neighbores : curr.neighbors) {
                // check for it is already visted or not
                if (!map.containsKey(neighbores)) {
                    Node neighboreClone = new Node(neighbores.val);
                    map.put(neighbores, neighboreClone);
                    stack.push(neighbores);
                }
                map.get(curr).neighbors.add(map.get(neighbores));
            }
        }
        return clone;
    }
}