package com.ex.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Ex_41_MedianInDataFlow {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeapComparator());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinHeapComparator());

    public void Insert(Integer num) {
        if (this.maxHeap.isEmpty()) {
            this.maxHeap.add(num);
            return;
        }

        if (num <= this.maxHeap.peek()) {
            this.maxHeap.add(num);
        } else {
            if (this.minHeap.isEmpty()) {
                this.minHeap.add(num);
                return;
            }

            if (num >= this.minHeap.peek()) {
                this.minHeap.add(num);
            } else {
                this.maxHeap.add(num);
            }
        }

        modifyTwoHeapSize();
    }

    public Double GetMedian() {
        int maxHeapSize = this.maxHeap.size();
        int minHeapSize = this.minHeap.size();

        // 若MaxHeap或者minHeap为空，则直接return null
        if (maxHeapSize + minHeapSize == 0) {
            return null;
        }

        Integer max = this.maxHeap.peek();
        Integer min = this.minHeap.peek();

        if (maxHeapSize == minHeapSize) {
            return (max + min) / 2.0;
        }

        return 1.0 * (maxHeapSize > minHeapSize ? max : min);
    }

    private void modifyTwoHeapSize() {
        if (this.maxHeap.size() == this.minHeap.size() + 2) {
            this.minHeap.add(this.maxHeap.poll());
        }

        if (this.minHeap.size() == this.maxHeap.size() + 2) {
            this.maxHeap.add(this.minHeap.poll());
        }
    }

    private static class MinHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    private static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 > o1 ? 1 : -1;
        }
    }
}
