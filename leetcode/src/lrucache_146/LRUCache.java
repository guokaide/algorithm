package lrucache_146;


import java.util.HashMap;

/**
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/description/
 */
public class LRUCache {
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity * 4 / 3);

        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        // key 不存在
        if (!map.containsKey(key)) {
            return -1;
        }

        // key 存在
        Node node = map.get(key);
        delete(node);
        insertToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        // key 存在
        if (map.containsKey(key)) {
            Node node = map.get(key);
            delete(node);
        }
        // key 不存在
        Node node = new Node(key, value);
        insertToHead(node);
        map.put(key, node);

        if (map.size() > capacity) {
            Node remove = deleteTail();
            map.remove(remove.key);
        }
    }

    private void delete(Node node) {
        Node next = node.next;
        Node pre = node.pre;

        pre.next = next;
        next.pre = pre;

        node.next = null;
        node.pre = null;
    }

    private void insertToHead(Node node) {
        Node next = head.next;
        node.next = next;
        node.pre = head;

        next.pre = node;
        head.next = node;
    }

    private Node deleteTail() {
        Node node = tail.pre;

        Node pre = node.pre;
        tail.pre = pre;
        pre.next = tail;

        node.next = null;
        node.pre = null;

        return node;
    }

    private class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
