class Solution {
    public int maxArea(int[] heights) {
        // Two pointers -> TC: O(n), SC: O(1)
        // Start with maximum possible width
        int left = 0;
        int right = heights.length - 1;

        int result = 0;

        // Keep shrinking the window
        while (left < right) {
            // Width between the two walls
            int width = right - left;

            // Water level is decided by smaller wall
            int area = Math.min(heights[left], heights[right]) * width;

            // Store maximum area found so far
            result = Math.max(result, area);

            /*
             Key Greedy Insight:

             Area depends on:
             min(height[left], height[right]) * width

             Width will ALWAYS decrease when pointers move.

             So the only hope of getting a larger area
             is finding a taller smaller wall.

             Therefore:
             - Move the smaller height pointer
             - Keep the taller one

             Because moving the taller one cannot help.
            */

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}