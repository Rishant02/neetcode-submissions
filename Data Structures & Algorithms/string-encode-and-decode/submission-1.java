class Solution {

    public String encode(List<String> strs) {
        // Naive approach should be to join all strs with delimiter
        // but doing this with ascii character is difficult to handle
        // Approach: Length + delimiter(_) + str
        // TC: O(n), SC: O(n)
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length())
                .append("_")
                .append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        // TC: O(n), SC: O(1)
        List<String> result = new ArrayList<>();
        int i = 0;
        // {length}{_}{word}
        while (i < str.length()){
            // find length before (_)
            int j = i; 
            while(str.charAt(j) != '_'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            // extract word
            String word = str.substring(j + 1, j + 1 + length);
            result.add(word);
            // move pointer to next word
            i = j + 1 + length;
        }
        return result;
    }
}
