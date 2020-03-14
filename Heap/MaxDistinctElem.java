package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxDistinctElem {
    public static int maxDistinctEle(int[] a, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : a) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(freq.size(), Comparator.reverseOrder());
        for (int value : freq.values()) {
            maxHeap.add(value);
        }

        for (int i = 0; i < k; i++) {
            int ele = maxHeap.poll();
            ele--;
            if (ele != 0) {
                maxHeap.add(ele);
            }
        }
        return maxHeap.size();
    }

    public static void main(String[] args) {
        int[] arr = { 5, 7, 5, 5, 1, 2, 2 };
        System.out.println(maxDistinctEle(arr, 3));
    }
}
