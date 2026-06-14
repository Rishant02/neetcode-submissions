class LRUCache {

    // Each cache entry is a node in the doubly linked list
    class Node {
        int key;
        int value;

        // Needed for O(1) removal from the list
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Maximum cache size
    private final int capacity;

    // key -> node reference
    // Gives O(1) access to any cache entry
    private final Map<Integer, Node> map;

    // Dummy nodes
    // head.next = Most Recently Used (MRU)
    // tail.prev = Least Recently Used (LRU)
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy nodes remove edge cases
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        // Cache miss
        if (!map.containsKey(key)) {
            return -1;
        }

        // Get the node directly in O(1)
        Node node = map.get(key);

        // Since it was accessed,
        // it becomes the most recently used item
        remove(node);
        insertAfterHead(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Case 1: key already exists
        if (map.containsKey(key)) {

            Node existing = map.get(key);

            // Update value
            existing.value = value;

            // Move it to MRU position
            remove(existing);
            insertAfterHead(existing);

            return;
        }

        // Case 2: cache full
        if (map.size() == capacity) {

            // LRU node is always before tail
            Node lru = tail.prev;

            // Remove from linked list
            remove(lru);

            // Remove from hashmap
            map.remove(lru.key);
        }

        // Create new cache entry
        Node newNode = new Node(key, value);

        // New item is always MRU
        insertAfterHead(newNode);

        // Store reference in hashmap
        map.put(key, newNode);
    }

    // Insert node right after head
    // Position = Most Recently Used
    private void insertAfterHead(Node node) {

        /*
            Before:

            head <-> A <-> B

            Insert node:

            head <-> node <-> A <-> B
         */

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Remove node from its current position
    private void remove(Node node) {

        /*
            Before:

            X <-> node <-> Y

            After:

            X <-> Y
         */

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}