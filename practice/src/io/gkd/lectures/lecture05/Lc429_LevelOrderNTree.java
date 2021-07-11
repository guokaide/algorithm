package io.gkd.lectures.lecture05;

import io.gkd.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Medium
 * 429. https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class Lc429_LevelOrderNTree {

    public List<List<Integer>> levelOrder(Node root) {
        // result: [[1], [3, 2, 4], [5, 6]]
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        // Queue: Node - depth
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        // Put root in Queue
        q.add(new Pair<Node, Integer>(root, 0));
        while (!q.isEmpty()) {
            Pair<Node, Integer> pair = q.poll();
            Node node = pair.getKey();
            int depth = pair.getValue();
            // initialize a list in every depth(0...)
            if (result.size() <= depth) {
                result.add(new ArrayList<Integer>());
            }
            result.get(depth).add(node.val);
            for (Node child : node.children) {
                q.add(new Pair<>(child, depth + 1));
            }
        }
        return result;
    }

    static class Pair<K, V> {

        public K key;
        public V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
