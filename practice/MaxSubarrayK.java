package practice;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxSubarrayK {

    public static void main(String[] args) {
        int arr[] = { 1,3,1,2,0,5 };
        int k = 3;
        System.out.println("getMaximum(arr,k) = " + getMaximum(arr, k));
    }

    private static List<Integer> getMaximum(int[] a, int k) {
        Deque<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int i;
        for (i = 0; i < k; i++) {
            removeUnrequiredElements(queue, a, a[i]);
            queue.add(i);
        }

        for (; i < a.length; i++) {
            res.add(a[queue.peek()]);
            removeOutOfWindowElems(queue,i,k);
            removeUnrequiredElements(queue,a,a[i]);
            queue.add(i);
        }
        res.add(a[queue.peek()]);
        return res;
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
