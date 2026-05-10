class Solution {
    public int longestConsecutive(int[] nums) {
        // Using hashset
        // Intuition: We need to find starting point of sequence
        // Once found, then find the longest sequence using set
        // TC: O(n), SC: O(n)
        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);

        int longest = 0;
        for(int num: nums){
            // if starting point exist in array, skip it
            if(set.contains(num - 1)) continue;
            int current = num;
            int streak = 1;
            while(set.contains(current + 1)){
                streak++;
                current++;
            }
            longest = Math.max(longest, streak);
        }
        return longest;
    }
}
