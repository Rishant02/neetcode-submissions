class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Monotonic decreasing stack of indices.
        // Stack stores days whose next warmer temperature hasn't been found yet.
        // When current temperature is warmer than the temperature at the stack top,
        // we've found the answer for that day: distance = currentIndex - previousIndex.
        // Each index is pushed once and popped once => O(n) time, O(n) space.

        int n = temperatures.length;
        int[] result = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }

        return result;
    }
}