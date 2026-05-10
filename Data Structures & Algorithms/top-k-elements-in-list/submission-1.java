class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // intution: First create a frequency map
        // then sort keys in descending order of freq
        // to find the top frequency numbers
        // TC: O(n * log n), SC: O(n)

        // count frequency
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));

        int[] topK = new int[k];
        for(int i = 0; i < k; i++){
            topK[i] = list.get(i);
        }

        return topK;
    }
}
