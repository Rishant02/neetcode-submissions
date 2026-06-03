class MinStack {
    // O(n) TC getMin
    private Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(int num : stack){
            min = Math.min(min, num);
        }
        return min;
    }
}
