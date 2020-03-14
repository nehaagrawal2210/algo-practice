package practice1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Sorting {


    //1. Insertion
    //2. Bubble
    //3. Selection
    //4. Merge
    //5. Quicksort
    //6. Counting
    //7. Radix sort
    //8. Heapsort

    public static int[] countingSort(int[] a) {
        int[] temp = new int[a.length];

        //count occurrences
        for (int num : a) {
            temp[num]++;
        }

        for (int i = 0, index = 0; i < temp.length; i++) {
            for (int count = 0; count < temp[i]; count++) {
                a[index++] = i;
            }
        }
        return a;
    }

    public static int[] heapSort(int[] a) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : a) {
            pq.add(n);
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = pq.poll();
        }
        return a;
    }

    public static int[] mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
        return a;
    }

    private static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int[] left = new int[mid - low + 1];
        int[] right = new int[high - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = a[i + low];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = a[i + mid + 1];
        }

        int mergedIdx = low, lIdx = 0, rIdx = 0;
        while (lIdx < left.length && rIdx < right.length) {
            if (left[lIdx] < right[rIdx]) {
                a[mergedIdx++] = left[lIdx++];
            } else {
                a[mergedIdx++] = right[rIdx++];
            }
        }

        while (lIdx < left.length) {
            a[mergedIdx++] = left[lIdx++];
        }

        while (rIdx < right.length) {
            a[mergedIdx++] = right[rIdx++];
        }
    }

    private static int partition(int[] a, int p, int r) {
        int random = (int) (Math.random() * (r - p + 1)) + p;
        //randomize pivot
        swap(a, p, random);

        int pivot = a[p];
        int i = p;
        for (int j = p + 1; j <= r; j++) {
            if (a[j] < pivot) {
                swap(a, i + 1, j);
                i++;
            }
        }
        swap(a, i, p);
        return i;
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivot = partition(a, low, high);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }
    }

    public static int[] quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
        return a;
    }

    public static int[] insertionSort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int key = a[i], j;
            for (j = i - 1; j >= 0 && a[j] > key; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = key;
        }
        return a;
    }

    public static int[] bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
        return a;
    }

    public static int[] selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minPos]) {
                    minPos = j;
                }
            }
            swap(a, i, minPos);
        }
        return a;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int a[] = {5, 8, 1, 0, 10, 6, 7};

        int[] insertionSort = insertionSort(Arrays.copyOf(a, a.length));
        System.out.println(Arrays.toString(insertionSort));

        int[] bubbleSort = bubbleSort(Arrays.copyOf(a, a.length));
        System.out.println(Arrays.toString(bubbleSort));

        int[] selectionSort = selectionSort(Arrays.copyOf(a, a.length));
        System.out.println(Arrays.toString(selectionSort));

        int[] mergeSort = mergeSort(Arrays.copyOf(a, a.length));
        System.out.println(Arrays.toString(mergeSort));

        int[] quickSort = quickSort(Arrays.copyOf(a, a.length));
        System.out.println(Arrays.toString(quickSort));

        int[] heapSort = heapSort(Arrays.copyOf(a, a.length));
        System.out.println(Arrays.toString(heapSort));

        int[] b = {1, 4, 1, 2, 6, 5, 2};
        int[] countSort = countingSort(b);
        System.out.println(Arrays.toString(countSort));
    }
}
