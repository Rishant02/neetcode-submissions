class Solution {
    public int maxArea(int[] heights) {
        // brute force -> TC: O(n^2), SC: O(1)
        // A(i, j) = Min(H(i), H(j)) * (j - i)
        int result = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int area = Math.min(heights[i], heights[j]) * (j - i);
                result = Math.max(result, area);
            }
        }
        return result;
    }
}
