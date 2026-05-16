class Solution {
    public int trap(int[] height) {
        // Water level depends upon tallest bar on left and right
        // Since water can only rise up to shorter boundary
        // water[i] = min(max(l), max(r)) - h[i]
        int n = height.length;
        int water = 0;
        // TC: O(n^2) Solution
        for(int i = 0; i < n; i++){
            int leftMax = 0;
            int rightMax = 0;

            for(int l = 0; l <= i; l++){
                leftMax = Math.max(leftMax, height[l]);
            }
            for(int r = i; r < n; r++){
                rightMax = Math.max(rightMax, height[r]);
            }
            int currentWater = Math.min(leftMax, rightMax) - height[i];
            if(currentWater > 0) water += currentWater;
        }
        return water;
    }
}
