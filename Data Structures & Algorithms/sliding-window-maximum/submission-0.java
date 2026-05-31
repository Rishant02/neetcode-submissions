class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // TC: O((n - k + 1). k), SC: O(n - k + 1)
        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int maxEl = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                maxEl = Math.max(maxEl, nums[j]);
            }
            res[i] = maxEl;
        }
        return res;
    }
}