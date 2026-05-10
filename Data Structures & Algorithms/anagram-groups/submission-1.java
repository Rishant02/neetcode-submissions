class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Intuition: For every string, use alphabetic freq count
        // and check in map if that array order exist
        // TC: O(n * m) -> where m is longest string
        // SC: O(n)
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            int[] count = new int[26];
            // all str are made of lowercase letters
            for(int i = 0; i < s.length(); i++){
                count[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(count);
            if(!map.containsKey(key)){
                map.putIfAbsent(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
