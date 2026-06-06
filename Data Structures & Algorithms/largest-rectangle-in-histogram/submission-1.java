class Solution {

    public int largestRectangleArea(int[] heights) {

        // For each bar:
        // width = NSE - PSE - 1
        // area = width * height

        // TC: O(n), SC: O(2*n)

        int[] nse = getNse(heights);
        int[] pse = getPse(heights);

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int width = nse[i] - pse[i] - 1;
            maxArea = Math.max(maxArea, width * heights[i]);
        }

        return maxArea;
    }

    private int[] getNse(int[] arr) {

        // Next Smaller Element index on the right.
        // If none exists, use n as the right boundary.

        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            // Remove elements that can't be next smaller.
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? n : stack.peek();

            stack.push(i);
        }

        return result;
    }

    private int[] getPse(int[] arr) {

        // Previous Smaller Element index on the left.
        // If none exists, use -1 as the left boundary.

        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Remove elements that can't be previous smaller.
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        return result;
    }
}