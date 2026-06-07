class TimeMap {
    private static class Pair{
        int timestamp;
        String value;

        Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);
        int l = 0, r = list.size() - 1;
        String ans = "";

        while(l <= r){
            int mid = l + (r - l) / 2;

            // valid timestamp, try find larger one
            if(list.get(mid).timestamp <= timestamp){
                ans = list.get(mid).value;
                l = mid + 1;
            }
            // need an earlier timestamp
            else{
                r = mid - 1;
            }
        }

        return ans;
    }
}
