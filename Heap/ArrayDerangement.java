package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ArrayDerangement {
    public static int[] derangement(int[] a) {
        int[] res = new int[a.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>(a.length, Comparator.reverseOrder());
        for (int n : a) {
            pq.add(n);
        }

        for (int i = 0; i < a.length; i++) {
            int d = pq.poll();
            if (d != a[i] || i == a.length - 1) {
                res[i] = d;
            } else {
                res[i] = pq.poll();
                pq.add(d);
            }
        }

        if (a[a.length - 1] == res[a.length - 1]) {
            res[a.length - 1] = res[a.length - 2];
            res[a.length - 2] = a[a.length - 1];
        }

        return res;
    }

    public static void main(String[] args) {
        int seq[] = { 5, 4, 3, 2, 1 };
        System.out.println(Arrays.toString(derangement(seq)));

        int seq1[] = { 56, 21, 42, 67, 23, 74 };
        System.out.println(Arrays.toString(derangement(seq1)));
    }
}
