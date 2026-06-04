class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // TC: O(n^2), SC: O(1) Brute force
        int n = temperatures.length;
        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(temperatures[j] > temperatures[i]){
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
