class MinStack {
    // Stores all elements normally
    private Stack<Integer> stack;

    // Stores only the minimum elements seen so far
    // Duplicate minimums are also stored to handle cases like:
    // push(2), push(2), pop() -> min should still be 2
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        // Always push into the main stack
        stack.push(val);

        // Push into minStack only if:
        // 1. minStack is empty (first element)
        // 2. val is smaller than or equal to current minimum
        //
        // Using <= is important for duplicate minimums.
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;

        // Remove top element from main stack
        int top = stack.pop();

        // If the removed element was the current minimum,
        // remove it from minStack as well.
        //
        // Example:
        // stack    = [5, 2, 8]
        // minStack = [5, 2]
        //
        // pop() removes 8 -> minStack unchanged
        //
        // stack    = [5, 2]
        // minStack = [5, 2]
        //
        // pop() removes 2 -> also remove 2 from minStack
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        // Return the top element of the main stack
        return stack.peek();
    }

    public int getMin() {
        // Current minimum is always on top of minStack
        return minStack.peek();
    }
}