package practice1;

import java.util.Arrays;

public class Heap {

    private int[] heap;
    private int capacity = 100;
    private int heapSize;

    public Heap(int capactiy) {
        this.capacity = capactiy;
        heap = new int[this.capacity];
        heapSize = 0;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChild(int index) {
        return 2 * index + 1;
    }

    private int getRightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private void heapify(int index) {

        int leftChildIndex = getLeftChild(index);
        int rightChildIndex = getRightChild(index);
        int largest = index;
        if (leftChildIndex < heapSize && heap[leftChildIndex] > heap[largest]) {
            largest = leftChildIndex;
        }
        if (rightChildIndex < heapSize && heap[rightChildIndex] > heap[largest]) {
            largest = rightChildIndex;
        }

        if (largest != index) {
            //swap the index with largest index
            swap(index, largest);
            heapify(largest);
        }
    }

    public void insertKey(int num) {
        if (heapSize == capacity) {
            System.out.println("Overflow Exception!!");
            return;
        }

        heap[heapSize] = num;
        int i = heapSize;
        heapSize++;

        while (i != 0) {
            int parentIndex = getParent(i);
            if (heap[parentIndex] >= heap[i]) {
                break;
            }
            swap(parentIndex, i);
            i = parentIndex;
        }
    }

    public int getMax() {
        if (heapSize == 0) {
            return Integer.MIN_VALUE;
        }
        return heap[0];
    }

    public int extractMax() {
        if (heapSize == 0) {
            return Integer.MIN_VALUE;
        }
        if (heapSize == 1) {
            heapSize = 0;
            return heap[0];
        }
        int max = heap[0];
        swap(0, heapSize - 1);
        heapSize--;
        heapify(0);
        return max;
    }

    public void heapSort(int[] a) {
        for (int n : a) {
            insertKey(n);
        }

        for (int i = a.length - 1; i >= 0; i--) {
            int max = extractMax();
            a[i] = max;
            heapify(0);
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap(50);
        int a[] = {5, 8, 1, 0, 10, 6, 7};
        h.heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
