class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        while (true) {
            int i = 0;
            for (; i < tickets.length; i++) {
                if (tickets[i] == 0) {
                    continue;
                }
                time++;
                if (i == k) {
                    if (tickets[i] == 1) {
                        return time;
                    }
                    tickets[i]--;
                    continue;
                }
                tickets[i]--;
            }
        }
    }
}