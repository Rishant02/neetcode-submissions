class Solution {
    public boolean isPalindrome(String s) {
        // Two pointer: TC: O(n), SC: O(1)
        int left = 0, right = s.length() - 1;

        while(left < right){
            // start with leftmost alphanumeric character
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            // ends with rightmost alphanumeric character
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            char l = Character.toLowerCase(s.charAt(left));
            char r = Character.toLowerCase(s.charAt(right));
            if(l != r) return false;

            left++;
            right--;
        }
        return true;
    }
}
