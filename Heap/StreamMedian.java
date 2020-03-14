package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StreamMedian {

    public static void median(int[] a) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(a.length, Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(a.length);

        double runningMedian = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= runningMedian) {
                maxHeap.add(a[i]);
            } else {
                minHeap.add(a[i]);
            }

            if (maxHeap.size() == minHeap.size()) {
                runningMedian = (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else if (maxHeap.size() > minHeap.size()) {
                runningMedian = maxHeap.peek();
            } else {
                runningMedian = minHeap.peek();
            }
            System.out.println(runningMedian);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 15, 10, 20, 3 };
        int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        median(arr1);
    }
}
