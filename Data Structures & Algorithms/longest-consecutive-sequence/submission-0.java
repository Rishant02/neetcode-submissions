class Solution {
    public int longestConsecutive(int[] nums) {
        // Brute force intuition: For every num,
        // scan whole array with increasing num + 1 for every
        // found consecutive number
        // TC: O(n ^ 2)
        int longest = 0;
        for(int num: nums){
            int currentNumber = num;
            int streak = 1; // num is already traversed
            while(contains(nums, currentNumber + 1)){
                currentNumber++;
                streak++;
            }
            longest = Math.max(longest, streak);
        }
        return longest;
    }
    private boolean contains(int[] nums, int target){
        for(int num : nums){
            if(num == target) return true;
        }
        return false;
    }
}
