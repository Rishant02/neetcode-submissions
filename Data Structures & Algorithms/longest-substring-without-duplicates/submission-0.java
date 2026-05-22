class Solution {
    public int lengthOfLongestSubstring(String s) {

        // HashSet stores unique characters
        // inside current sliding window
        Set<Character> set = new HashSet<>();

        // Left pointer -> start of window
        int left = 0;

        // Stores maximum length found
        int maxLen = 0;

        // Right pointer expands window
        for (int right = 0; right < s.length(); right++) {

            // INTUITION:
            // If current character already exists,
            // window becomes invalid because
            // substring cannot contain duplicates.
            //
            // So shrink window from left side
            // until duplicate character is removed.
            while (set.contains(s.charAt(right))) {

                // Remove leftmost character
                set.remove(s.charAt(left));

                // Move left pointer forward
                left++;
            }

            // Add current character into valid window
            set.add(s.charAt(right));

            // Length of current valid window
            int currentLen = right - left + 1;

            // Update answer
            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }
}

/*
Time Complexity: O(n)

Reason:
- Each character is added to the HashSet once
- Each character is removed from the HashSet once
- left and right pointers only move forward

So total operations are linear.

Space Complexity: O(m)
- where m are unique characters in string
Reason:
- HashSet can store at most all unique characters
*/