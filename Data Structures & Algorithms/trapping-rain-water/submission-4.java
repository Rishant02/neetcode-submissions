class Solution {
    public int trap(int[] height) {

        /*
         * Intuition:
         * Water trapped at any index depends on:
         *
         * min(max height on left, max height on right) - current height
         *
         * Instead of storing prefix/suffix max arrays,
         * we optimize space using two pointers.
         *
         * Key Observation:
         * - If left height < right height,
         *   then left side becomes the limiting boundary.
         *   So water trapped at left depends only on leftMax.
         *
         * - Similarly, if right height <= left height,
         *   then right side becomes the limiting boundary.
         *
         * We process the smaller side first because
         * the smaller boundary determines water level.
         *
         * TC: O(n)
         * SC: O(1)
         */

        int n = height.length;

        // Two pointers
        int left = 0;
        int right = n - 1;

        // Maximum boundary seen so far from left and right
        int leftMax = 0;
        int rightMax = 0;

        // Stores total trapped water
        int water = 0;

        while (left < right) {

            // Process the smaller boundary first
            if (height[left] < height[right]) {

                /*
                 * If current bar is taller than previous leftMax,
                 * update leftMax because it becomes new boundary.
                 */
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {

                    /*
                     * Water trapped =
                     * left boundary - current height
                     */
                    water += leftMax - height[left];
                }

                // Move left pointer inward
                left++;

            } else {

                /*
                 * If current bar is taller than previous rightMax,
                 * update rightMax because it becomes new boundary.
                 */
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {

                    /*
                     * Water trapped =
                     * right boundary - current height
                     */
                    water += rightMax - height[right];
                }

                // Move right pointer inward
                right--;
            }
        }

        return water;
    }
}