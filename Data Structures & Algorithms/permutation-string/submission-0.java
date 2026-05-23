class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // If s1 is bigger, impossible to have its permutation inside s2
        if (s1.length() > s2.length()) return false;

        // need[]  -> stores frequency of characters required from s1
        // window[] -> stores frequency of current sliding window in s2
        int[] need = new int[26];
        int[] window = new int[26];

        // Build frequency map of s1
        // Example: s1 = "ab"
        // need[a] = 1, need[b] = 1
        for (char c : s1.toCharArray()) {
            need[c - 'a']++;
        }

        int left = 0;

        // Expand sliding window using right pointer
        for (int right = 0; right < s2.length(); right++) {
            // Include current character into window
            // Think of this as adding character into our "bag"
            window[s2.charAt(right) - 'a']++;

            // Keep window size fixed equal to s1.length()
            // If window becomes larger, remove leftmost char
            if ((right - left + 1) > s1.length()) {
                // Remove character going out of window
                window[s2.charAt(left) - 'a']--;
                // Shrink window
                left++;
            }
            /*
             Intuition:
             If frequency of current window becomes exactly same as s1,
             then current substring is just a rearrangement (permutation)
             of s1.
            */
            if (matches(need, window)) {
                return true;
            }
        }

        // No permutation found
        return false;
    }

    // Compare both frequency arrays
    // If all counts match -> permutation exists
    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            // Any mismatch means window is not a permutation
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}