class Solution {
    public int trap(int[] height) {
        // Water level depends upon tallest bar on left and right
        // Since water can only rise up to shorter boundary
        // water[i] = min(max(l), max(r)) - h[i]

        // TC: O(3n), SC: O(2n) Prefix/ Suffix Solution
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for(int i = 1; i < n; i++) leftMax[i] = Math.max(height[i], leftMax[i-1]);
        for(int i = n - 2; i >= 0; i--) rightMax[i] = Math.max(height[i], rightMax[i+1]);

        int water = 0;
        for(int i = 0; i < n; i++){
            int currentWater = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(currentWater > 0) water += currentWater;
        }

        return water;
    }
}
