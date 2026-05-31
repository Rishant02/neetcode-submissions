class Solution {
    public String minWindow(String s, String t) {

        // Can't form a valid window if t is longer than s
        if (t.length() > s.length()) {
            return "";
        }

        // Think of this as a "shopping list".
        // freq[c] = how many more of character c we still need.
        int[] freq = new int[128];

        // Build the shopping list from t
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }

        // Total characters still missing to complete the shopping list
        int count = t.length();

        int left = 0;

        // Best window found so far
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Expand window by moving right pointer
        for (int right = 0; right < s.length(); right++) {

            char rc = s.charAt(right);

            // If this character was still needed,
            // we've fulfilled one requirement.
            if (freq[rc] > 0) {
                count--;
            }

            // Take this character into our window.
            // Negative value means we have extras.
            freq[rc]--;

            // Shopping list is complete.
            // Current window contains all characters of t.
            while (count == 0) {

                int windowLen = right - left + 1;

                // Record smaller valid window.
                if (windowLen < minLen) {
                    minLen = windowLen;
                    start = left;
                }

                // Try throwing away characters from the left
                // to make the window as small as possible.
                char lc = s.charAt(left);

                // Put this character back into the shopping list.
                freq[lc]++;

                // If freq becomes positive,
                // we are missing this character again.
                // Window is no longer valid.
                if (freq[lc] > 0) {
                    count++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}