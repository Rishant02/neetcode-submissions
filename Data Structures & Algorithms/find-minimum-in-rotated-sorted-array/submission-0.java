class Solution {
    public int findMin(int[] nums) {
        // TC: O(log n), SC: O(1)
        int res = nums[0];
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            // Current range is already sorted -> leftmost element is the minimum.
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }

            int mid = l + (r - l) / 2;
            res = Math.min(res, nums[mid]);

            // Left half is sorted, so minimum must be in right half.
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            }
            // Pivot/minimum lies in the left half.
            else {
                r = mid - 1;
            }
        }

        return res;
    }
}