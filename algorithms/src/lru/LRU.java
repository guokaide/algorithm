package lru;

import java.util.HashMap;
import java.util.Iterator;

/**
 * LRU Cache: 优先淘汰最久未使用的数据
 * Solution: 双向链表+HashMap
 * 1. 访问某个节点时，将其从原来的位置删除，并且重新插入到链表头部（保证链表尾部存储最近最久未使用的节点）。当节点数量大于缓存的
 * 最大空间时，就淘汰链表尾部的节点。使用双端链表是为了保证删除操作时间复杂度为O(1)。
 * 2. 为了使得删除操作的时间复杂度是O(1),就不能使用遍历的方式找到某个节点。HashMap存储的是Key到节点的映射，通过Key就能够以O(1)
 * 的时间得到节点，然后再以O(1)的时间将其从双向队列中删除。
 * 具体步骤：
 * 1. get(): 
 * 访问某个节点时，若这个节点不存在，返回null; 
 * 若这个节点存在，则将该节点从该位置删除，然后插入到链表头部，最后返回该节点的值。
 * 2. put():
 * 插入节点时，若这个节点存在，则将这个节点从原位置删除，然后插入到链表头部。
 * 若这个节点不存在，则新建一个节点，然后将这个节点插入链表头部，然后将该节点插入到map中
 * 此时，若map中节点的数量大于cache的容量，则将该链表尾部节点删除，同时在map中删除链表尾部节点。
 * 
 * Example:
 * head <-> 1,1 <-> 2,2 <-> 3,3 <-> tail;
 * put(2,2): head <-> 2,2 <-> 1,1 <-> 3,3 <-> tail;
 * get(3):   head <-> 3,3 <-> 2,2 <-> 1,1 <-> tail;
 *
 * @param <K>
 * @param <V>
 */
public class LRU<K,V> implements Iterable<K> {

    private Node head;
    private Node tail;
    private HashMap<K, Node> map;
    private int maxSize;


    private class Node {
        Node pre;
        Node next;
        K k;
        V v;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    public LRU(int maxSize) {
        this.maxSize = maxSize;
        this.map = new HashMap<>(maxSize * 4 / 3);

        head = new Node(null, null);
        tail = new Node(null, null);

        head.next = tail;
        tail.pre = head;
    }

    // O(1)
    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }

        Node node = map.get(key);
        unlink(node);
        appendToHead(node);

        return node.v;
    }

    // O(1)
    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            unlink(node);
        }

        Node node = new Node(key, value);
        appendToHead(node);
        map.put(key, node);

        if (map.size() > maxSize) {
            Node toRemove = removeTail();
            map.remove(toRemove.k);
        }
    }

    private Node removeTail() {
        Node node = tail.pre;

        Node pre = node.pre;
        tail.pre = pre;
        pre.next = tail;

        node.next = null;
        node.pre = null;

        return node;
    }

    private void appendToHead(Node node) {
        Node next = head.next;
        node.next = next;
        node.pre = head;
		
		next.pre = node;
        head.next = node;
    }

    private void unlink(Node node) {
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;

        node.pre = null;
        node.next = null;
    }

    @Override
    public Iterator<K> iterator() {
        return new LRUIterator<>();
    }

    private class LRUIterator<K> implements Iterator<K> {
        private Node cur = head.next;

        @Override
        public boolean hasNext() {
            return cur != tail;
        }

        @Override
        public K next() {
            Node node = cur;
            cur = cur.next;
            return (K) node.k;
        }
    }

}
