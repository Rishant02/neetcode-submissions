class Solution {
    public int largestRectangleArea(int[] heights) {
        // TC: O(n^2), SC: O(1)
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int minHeight = heights[i];

            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                if(minHeight == 0) break;

                int area = minHeight * (j - i + 1);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}