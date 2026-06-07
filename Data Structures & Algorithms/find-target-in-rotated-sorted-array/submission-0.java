class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            // Left half [l..mid] is sorted
            if (nums[mid] >= nums[l]) {
                // Target lies in sorted left half
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                }
                // Search right half
                else {
                    l = mid + 1;
                }
            }

            // Right half [mid..r] is sorted
            else {
                // Target lies in sorted right half
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                }
                // Search left half
                else {
                    r = mid - 1;
                }
            }
        }

        return -1; // Target not found
    }
}