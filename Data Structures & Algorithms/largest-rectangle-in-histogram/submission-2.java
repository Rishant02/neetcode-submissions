class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // TC: O(n), SC: O(n)
        // Stores indices of bars in increasing height order.
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            /*
             * When current bar is smaller, we've found the NSE
             * for all taller bars on the stack.
             *
             * For a popped bar:
             * - current index i = NSE
             * - new stack top = PSE
             * - width = NSE - PSE - 1
             */
            while (!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])) {
                int height = heights[stack.pop()];
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int width = i - pse - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            // i == n acts as a virtual bar of height 0
            // to flush all remaining bars from the stack.
            stack.push(i);
        }

        return maxArea;
    }
}