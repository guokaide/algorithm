package io.gkd.week02;

import java.util.HashMap;

/**
 * Medium
 * 146. https://leetcode-cn.com/problems/lru-cache/
 * Time: put、get: O(1)
 * Space: O(capacity)
 */
public class Lc146_LRUCache {
    // key - Node
    HashMap<Integer, Node> cache;
    int capacity;
    // sentinel head
    Node head;
    // sentinel tail
    Node tail;

    public Lc146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        // Doubly Linked List: head - tail
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key) {
        Node node = this.cache.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addToHead(node);
        return node.val;
    }

    // head -> latest -> ... -> oldest -> tail
    // head -> 1 -> 2 -> tail
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            removeNode(cache.get(key));
        }
        Node node = new Node(key, value);
        addToHead(node);
        this.cache.put(key, node);
        if (this.cache.size() > capacity) {
            Node oldestNode = tail.pre;
            removeNode(oldestNode);
            this.cache.remove(oldestNode.key);
        }
    }

    // O(1)
    private void addToHead(Node node) {
        // node - head.next
        node.next = this.head.next;
        this.head.next.pre = node;
        // head - node
        node.pre = this.head;
        this.head.next = node;
    }

    // O(1)
    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    static class Node {
        public int key;
        public int val;
        public Node pre;
        public Node next;

        public Node() {}

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
