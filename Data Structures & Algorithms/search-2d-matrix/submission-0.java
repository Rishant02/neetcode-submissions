class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // treat 2D matrix as flattened 1D array & perform BS
        // TC: O(log(m*n)), SC: O(1)
        int m = matrix.length;
        int n = matrix[0].length;

        int total = m * n;
        int l = 0, r = total - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int row = mid / n;
            int col = mid % n;

            int val = matrix[row][col];

            if (val == target) {
                return true;
            } else if (val > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
}