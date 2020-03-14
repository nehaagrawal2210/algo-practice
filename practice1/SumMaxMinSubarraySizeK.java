package practice1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SumMaxMinSubarraySizeK {

    public static void main(String[] args) {
        int arr[] = { 2, 5, -1, 7, -3, -1, -2};
        int k = 4;
        System.out.println("getSums(arr,k) = " + getSums(arr, k));
    }

    private static List<Integer> getSums(int[] a, int k) {
        Deque<Integer> queue = new LinkedList<>();
        Deque<Integer> minQ = new LinkedList<>();

        List<Integer> sum = new ArrayList<>();
        int i;
        for (i = 0; i < k; i++) {
            removeUnrequiredElements(queue, a, a[i]);
            removeUnrequiredFromMinQueue(minQ, a, a[i]);
            queue.add(i);
            minQ.add(i);
        }

        for (; i < a.length; i++) {
            sum.add(a[queue.peek()] + a[minQ.peek()]);
            removeOutOfWindowElems(queue, i, k);
            removeOutOfWindowElems(minQ, i, k);
            removeUnrequiredElements(queue, a, a[i]);
            removeUnrequiredFromMinQueue(minQ, a, a[i]);
            queue.add(i);
            minQ.add(i);
        }
        sum.add(a[queue.peek()] + a[minQ.peek()]);

        return sum;
    }

    private static void removeUnrequiredFromMinQueue(Deque<Integer> q, int[] a, int val) {
        while (!q.isEmpty() && a[q.peekLast()] >= val) {
            q.removeLast();
        }
    }

    private static void removeOutOfWindowElems(Deque<Integer> q, int curIndex, int windowSize) {
        while (!q.isEmpty() && q.peek() <= curIndex - windowSize) {
            q.poll();
        }
    }

    private static void removeUnrequiredElements(Deque<Integer> q, int[] a, int val) {
        while (!q.isEmpty() && a[q.peekLast()] <= val) {
            q.removeLast();
        }
    }
}
