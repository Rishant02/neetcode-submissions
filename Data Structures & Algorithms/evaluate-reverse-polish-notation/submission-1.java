class Solution {
    public int evalRPN(String[] tokens) {
        // TC: O(n), SC: O(n)
        // Stack stores operands
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            // Operator: pop operands, evaluate, push result
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());

            } else if (token.equals("-")) {
                int b = stack.pop(); // second operand
                int a = stack.pop(); // first operand
                stack.push(a - b);

            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());

            } else if (token.equals("/")) {
                int b = stack.pop(); // divisor
                int a = stack.pop(); // dividend
                stack.push(a / b);

            } else {
                // Operand: push number onto stack
                stack.push(Integer.parseInt(token));
            }
        }

        // Final result remains on top of stack
        return stack.pop();
    }
}