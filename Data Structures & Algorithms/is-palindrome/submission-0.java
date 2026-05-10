class Solution {
    public boolean isPalindrome(String s) {
        // TC: O(n), SC: O(n)
        String input = clean(s);
        String r = reverse(input);
        return input.equalsIgnoreCase(r);
    }
    private String clean(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    private String reverse(String s){
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        
        while(left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        return new String(arr);
    }
}
