import java.util.*;

class Solution {

    class Node {
        int value;
        int row;
        int col;

        Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Node> minHeap =
                new PriorityQueue<>((a, b) -> a.value - b.value);

        int max = Integer.MIN_VALUE;

        // Put first element of every list
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new Node(val, i, 0));
            max = Math.max(max, val);
        }

        int start = 0;
        int end = Integer.MAX_VALUE;

        while (true) {

            Node curr = minHeap.poll();
            int min = curr.value;

            // Better range found
            if (max - min < end - start) {
                start = min;
                end = max;
            }

            // If this list ends, we cannot continue
            if (curr.col + 1 == nums.get(curr.row).size()) {
                break;
            }

            // Next element from same list
            int next = nums.get(curr.row).get(curr.col + 1);

            minHeap.offer(new Node(next, curr.row, curr.col + 1));

            max = Math.max(max, next);
        }

        return new int[]{start, end};
    }
}
 