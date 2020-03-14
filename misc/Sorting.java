package misc;

import java.util.Random;

/**
 * Created by neha on 1/10/2017.
 */
public class Sorting {

    public void mergeSort(int a[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(a, l, mid);
            mergeSort(a, mid + 1, r);
            merge(a, l, mid, r);
        }
    }

    public void merge(int a[], int low, int mid, int high) {
        //copy elements into temp arrays
        int size1 = mid - low + 1;
        int size2 = high - mid;

        int l[] = new int[size1];
        int r[] = new int[size2];

        for (int i = 0; i < size1; i++)
            l[i] = a[low + i];
        for (int i = 0; i < size2; i++)
            r[i] = a[mid + i + 1];

        int k = low, i = 0, j = 0;

        while (i < size1 && j < size2) {
            if (l[i] < r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < size1) {
            a[k++] = l[i++];
        }
        while (j < size2) {
            a[k++] = r[j++];
        }
    }

    public void insertionSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int j = i - 1, key = a[i];
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }

    }

    public void selectionSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            //swap a[minIndex] with a[i]
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    public void bubbleSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String args[]) {
        Sorting s = new Sorting();
        int merge[] = {13, 5, 4, 2, 1};
        int insert[] = {13, 5, 4, 2, 1};
        int select[] = {13, 5, 4, 2, 1};
        int bubble[] = {13, 5, 4, 2, 1};
        int quick[] = {13, 5, 4, 2, 1};
        int heap[] = {13, 5, 4, 2, 1};
        int count[] = {8, 9, 6, 4, 3};

        s.mergeSort(merge, 0, merge.length - 1);
        System.out.println("\nMerge Sort:---------------------- ");
        s.traverse(merge);

        s.insertionSort(insert);
        System.out.println("\nInsertion Sort:------------------ ");
        s.traverse(insert);

        s.selectionSort(select);
        System.out.println("\nSelection Sort:------------------ ");
        s.traverse(select);

        s.bubbleSort(bubble);
        System.out.println("\nBubble Sort:------------------ ");
        s.traverse(bubble);

        s.heapSort(heap);
        System.out.println("\nMinHeap Sort:------------------ ");
        s.traverse(heap);

        s.quickSort(quick, 0, quick.length - 1);
        System.out.println("\nQuick Sort:------------------ ");
        s.traverse(quick);

        s.countSort(count, 15);
        System.out.println("\nCount Sort:------------------ ");
        s.traverse(count);
    }

    public void heapSort(int a[]) {
        int heapSize = a.length;

        //create heap
        for (int i = heapSize / 2; i >= 0; i--)
            heapify(a, heapSize, i);

        //root will be max element as max heap
        for (int i = heapSize - 1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a, i, 0);
        }
    }

    public void heapify(int a[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        //if left child is largest
        if (left < n && a[left] > a[largest])
            largest = left;

        //if right child is largest
        if (right < n && a[right] > a[largest])
            largest = right;

        if (largest != i) {
            int swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;

            heapify(a, n, largest);
        }
    }

    public void quickSort(int a[], int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            quickSort(a, p, q - 1);
            quickSort(a, q + 1, r);
        }
    }

    public int partition(int a[], int p, int q) {
        Random random = new Random();
        int randomIndex = random.nextInt(q + 1 - p) + p;

        //swap first with randomIndex elem
        int temp = a[p];
        a[p] = a[randomIndex];
        a[randomIndex] = temp;

        //get the pivot
        int pivot = a[p];

        int i = p;
        //partition around the pivot
        for (int j = p + 1; j <= q; j++) {
            if (a[j] <= pivot) {
                i++;
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        temp = a[p];
        a[p] = a[i];
        a[i] = temp;
        return i;
    }

    public void countSort(int a[], int range) {
        int n = a.length;
        int count[] = new int[range];
        int output[] = new int[n];

        //perform the count
        for (int i = 0; i < n; i++) {
            count[a[i]]++;
        }

//      perform running sum in count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        //build output char array
        for (int i = 0; i < n; i++) {
            output[count[a[i]] - 1] = a[i];
        }

        //copy output in original
        for (int i = 0; i < n; i++) {
            a[i] = output[i];
        }

    }

    public void traverse(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
