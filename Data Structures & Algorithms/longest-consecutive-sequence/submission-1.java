class Solution {
    public int longestConsecutive(int[] nums) {
        // using sorting, TC: O(n logn)
        if(nums.length == 0) return 0;
        Arrays.sort(nums);

        int longest = 0;
        int currentStreak = 1;

        for(int i = 1; i < nums.length; i++){
            // skip duplicate
            if(nums[i] == nums[i - 1]) continue;
            // consecutive number
            if(nums[i] == nums[i - 1] + 1){
                currentStreak++;
            }
            // break in sequence
            else{
                longest = Math.max(longest, currentStreak);
                currentStreak = 1;
            }
        }
        return Math.max(longest, currentStreak);
    }
}
