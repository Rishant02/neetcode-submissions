class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Two-pointer approach
        // Since the array is sorted in ascending order,
        // we can use two pointers at both ends.
        //
        // - If the current sum is too large,
        //   move the right pointer left to reduce the sum.
        //
        // - If the current sum is too small,
        //   move the left pointer right to increase the sum.
        //
        // This lets us find the target pair in a single pass.
        //
        // Time Complexity: O(n), Space Complexity: O(1)
        int left = 0, right = numbers.length - 1;

        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum > target) right--;
            else if(sum < target) left++;
            else return new int[] {left + 1, right + 1};
        }

        return new int[] {};
    }
}
