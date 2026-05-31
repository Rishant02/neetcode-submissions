class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        int[] freq = new int[128];
        // count frequency of t
        for(char ch: t.toCharArray()){
            freq[ch]++;
        }
        int count = t.length();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0; // minimum index starting index

        for(int right = 0; right < s.length(); right++){
            char rc = s.charAt(right);
            if(freq[rc] > 0){
                count--;
            }
            freq[rc]--;

            while(count == 0){
                int windowLen = right - left + 1;
                if(windowLen < minLen){
                    // found min len window
                    start = left;
                    minLen = windowLen;
                }
                char lc = s.charAt(left);
                freq[lc]++;

                if(freq[lc] > 0){
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
