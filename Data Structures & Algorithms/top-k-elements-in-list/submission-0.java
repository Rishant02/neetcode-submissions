class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // intution: First create a frequency map
        // then uses a min-heap to find the top frequency numbers
        // using min-heap to keep the heap size to K
        // TC: O(n * log k), SC: O(n)

        // count frequency
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue(
            (a, b) -> Integer.compare(map.get(a), map.get(b))
        );
        // keep only top k frequent
        for(int key: map.keySet()){
            heap.offer(key);
            if(heap.size() > k){
                heap.poll();
            }
        }
        // init result array
        int[] topK = new int[k];
        // traversing from last as it is min heap
        for(int i = k - 1; i >= 0; i--){
            topK[i] = heap.poll();
        }
        return topK;
    }
}
