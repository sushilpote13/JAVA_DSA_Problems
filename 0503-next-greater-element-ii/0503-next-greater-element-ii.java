import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        Stack<Integer> st = new Stack<>();      // Monotonic stack
        Stack<Integer> ansStack = new Stack<>(); // Stores answers

        // Traverse twice because array is circular
        for (int i = 2 * n - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }

            if (i < n) {
                if (st.isEmpty()) {
                    ansStack.push(-1);
                } else {
                    ansStack.push(st.peek());
                }
            }

            st.push(nums[i % n]);
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = ansStack.pop();
        }

        return ans;
    }
}