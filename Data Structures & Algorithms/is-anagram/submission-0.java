class Solution {
    public boolean isAnagram(String s, String t) {
        // O(n) TC & O(1) SC
        if(s.length() != t.length()) return false;
        // using hash count of alphabets
        int[] count = new int[26];
        // using s to increment and t to decrement
        for(int i = 0; i < s.length(); i++){
            // string only contains lowercase letters
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int c: count){
            if(c != 0) return false;
        }
        return true;
    }
}
