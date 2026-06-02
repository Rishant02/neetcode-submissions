class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Stores INDICES, not values.
        // Deque is maintained in decreasing order of values:
        // nums[q[0]] >= nums[q[1]] >= nums[q[2]] ...
        //
        // Therefore:
        // - Front always contains index of current maximum.
        // - Back contains weaker candidates.
        Deque<Integer> q = new ArrayDeque<>();

        for (int r = 0; r < n; r++) {

            // Remove indices that have moved out of the window.
            //
            // Current window's left boundary is:
            // left = r - k + 1
            //
            // Any index <= r - k is outside the window.
            while (!q.isEmpty() && q.peekFirst() <= r - k) {
                q.pollFirst();
            }

            // Remove all smaller elements from the back.
            //
            // Why?
            // If nums[r] is bigger, those smaller elements can never
            // become maximum in any future window while nums[r] exists.
            //
            // Example:
            // deque values = [8, 5, 3]
            // new value = 10
            //
            // 8, 5, and 3 are useless now.
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                q.pollLast();
            }

            // Add current index as a candidate maximum.
            q.offerLast(r);

            // Once we've formed the first complete window,
            // the maximum is always at the front of the deque.
            if (r >= k - 1) {
                result[r - k + 1] = nums[q.peekFirst()];
            }
        }

        return result;
    }
}