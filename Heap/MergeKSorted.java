package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSorted {

    class ArrayElement implements Comparable<ArrayElement> {
        int xIndex;
        int yIndex;
        int element;

        public ArrayElement(int xIndex, int yIndex, int element) {
            this.xIndex = xIndex;
            this.yIndex = yIndex;
            this.element = element;
        }

        @Override
        public int compareTo(ArrayElement o) {
            if (this.element < o.element) {
                return -1;
            }
            if (this.element == o.element) {
                return 0;
            }
            return 1;
        }
    }

    public int[] merge(int[][] a, int k) {
        PriorityQueue<ArrayElement> pq = new PriorityQueue<>(k);
        int resSize = 0;

        for (int i = 0; i < k; i++) {
            resSize += a[i].length;
        }

        for (int i = 0; i < k; i++) {
            pq.add(new ArrayElement(i, 0, a[i][0]));
        }

        int[] res = new int[resSize];
        for (int i = 0; i < resSize; i++) {
            ArrayElement ele = pq.poll();
            res[i] = ele.element;
            if (ele.yIndex + 1 < a[ele.xIndex].length) {
                pq.add(new ArrayElement(ele.xIndex, ele.yIndex + 1, a[ele.xIndex][ele.yIndex + 1]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 3, 5 }, { 2, 4, 6, 8 }, { 0, 9, 10, 11, 12 } };
        int[] res = new MergeKSorted().merge(arr, 3);
        System.out.println("res = " + Arrays.toString(res));
    }
}
