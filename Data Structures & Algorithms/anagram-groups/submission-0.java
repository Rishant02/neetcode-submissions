class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Intuition: For every string, sort it and check
        // in map, if that exist and add it in same key value
        // TC: O(n * m log m) -> m is the longest string in strs
        // SC: O(n)
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            // create char array to sort the string
            char[] chars = s.toCharArray();
            // sort it
            Arrays.sort(chars);
            // Create string key
            String key = new String(chars);
            // check if key exist in map
            if(!map.containsKey(key)){
                map.putIfAbsent(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
