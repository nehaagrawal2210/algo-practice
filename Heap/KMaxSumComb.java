package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import javafx.util.Pair;

public class KMaxSumComb {

    class SumElem implements Comparable<SumElem> {
        int sum;
        int aIdx;
        int bIdx;

        @Override
        public int compareTo(SumElem o) {
            return o.sum - this.sum;
        }

        public SumElem(int aIdx, int bIdx, int sum) {
            this.aIdx = aIdx;
            this.bIdx = bIdx;
            this.sum = sum;
        }
    }

    public int[] kMaxSumCom(int[] a, int[] b, int k) {
        int[] res = new int[k];
        PriorityQueue<SumElem> maxHeap = new PriorityQueue<SumElem>(k);
        Set<Pair<Integer, Integer>> indexes = new HashSet<>();
        Arrays.sort(a);
        Arrays.sort(b);
        indexes.add(new Pair<>(a.length - 1, b.length - 1));
        maxHeap.add(new SumElem(a.length - 1, b.length - 1, a[a.length - 1] + b[b.length - 1]));
        for (int i = 0; i < k; i++) {
            SumElem sumElem = maxHeap.poll();
            res[i] = sumElem.sum;
            Pair<Integer, Integer> p1 = new Pair(sumElem.aIdx - 1, sumElem.bIdx);
            Pair<Integer, Integer> p2 = new Pair(sumElem.aIdx, sumElem.bIdx - 1);
            if (!indexes.contains(p1)) {
                maxHeap.add(new SumElem(p1.getKey(), p1.getValue(), a[p1.getKey()] + b[p1.getValue()]));
                indexes.add(p1);
            }
            if (!indexes.contains(p2)) {
                maxHeap.add(new SumElem(p2.getKey(), p2.getValue(), a[p2.getKey()] + b[p2.getValue()]));
                indexes.add(p2);
            }
        }
        return res;
    }

    private int getMax(int[] a, int currentMax) {
        int max = currentMax;
        for (int n : a) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    private PriorityQueue<Integer> getMaxHeap(int[] a) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(a.length, Comparator.reverseOrder());
        for (int n : a) {
            maxHeap.add(n);
        }
        return maxHeap;
    }

    public static void main(String[] args) {
        KMaxSumComb comb = new KMaxSumComb();
        int A[] = { 3, 7, 2, 1 };
        int B[] = { 8, 0, 3, 5 };
        System.out.println(Arrays.toString(comb.kMaxSumCom(A, B, 3)));
    }
}
