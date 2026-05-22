class Solution {
    public int characterReplacement(String s, int k) {
        // TC: O(26 * n), SC: O(1)
        // Frequency array to store count of A-Z
        int[] freq = new int[26];
        // Left pointer of sliding window
        int left = 0;
        // Stores maximum valid window length
        int ans = 0;

        // Expand window using right pointer
        for (int right = 0; right < s.length(); right++) {
            // Add current character into frequency array
            freq[s.charAt(right) - 'A']++;
            // Find maximum frequency character in current window
            int maxFreq = Arrays.stream(freq).max().getAsInt();

            /*
             * If:
             * window size - most frequent character count > k
             *
             * then more than k replacements are needed,
             * so shrink the window from left side
             */
            while ((right - left + 1) - maxFreq > k) {
                // Remove left character from frequency count
                freq[s.charAt(left) - 'A']--;
                // Move left pointer forward
                left++;
            }

            // Store maximum valid window length
            ans = Math.max(ans, right - left + 1);
        }

        // Return longest valid substring length
        return ans;
    }
}