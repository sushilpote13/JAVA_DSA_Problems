class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            if (i == k) {
                queue.add(null);
                queue.add(tickets[i]);
                continue;
            }
            queue.add(tickets[i]);
        }
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                int temp = queue.poll();
                temp--;
                if (temp != 0) {
                    queue.add(temp);
                }
                time++;
            } else {
                queue.poll();
                if (queue.peek() == 1) {
                    return time + 1;
                }
                queue.add(null);
            }
        }
        return time;
    }
}