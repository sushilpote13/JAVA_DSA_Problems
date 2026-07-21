class Solution {
    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        int[] nextSmallestRight = new int[size];
        int[] nextSmallestLeft = new int[size];
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        // create nextSmallestRight array
        for (int i = size - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nextSmallestRight[i] = size;
            } else {
                nextSmallestRight[i] = stack.peek();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            stack.pop();
        }
        // create nextSmallestLeft array
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nextSmallestLeft[i] = -1;
            } else {
                nextSmallestLeft[i] = stack.peek();
            }
            stack.push(i);
        }
        // calculate the area and return
        for (int i = 0; i < size; i++) {
            int width = nextSmallestRight[i] - nextSmallestLeft[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(area, maxArea);
        }
        // return statement
        return maxArea;
    }
}