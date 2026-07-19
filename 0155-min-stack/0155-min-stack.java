class MinStack {
    // so we can use Node and stor the current minimum in this
    class Node {
        int value;
        int min;

        Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    //Now we have create a Stack 
    Stack<Node> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int value) {
        // check weather it is empty or not 
        Node node;
        if (stack.isEmpty()) {
            node = new Node(value, value);
        } else {
            node = new Node(value, Math.min(value, stack.peek().min));
        }
        stack.push(node);
    }

    public void pop() {
        // before poping check for empty 
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */