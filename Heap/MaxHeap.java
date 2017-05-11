package Heap;

import misc.Heap;

import java.util.Arrays;

/**
 * Created by neha on 2/26/2017.
 */
public class MaxHeap {
    int CAPACITY;
    int[] a;
    int heapSize;

    public MaxHeap(int capacity)
    {
        heapSize=0;
        CAPACITY=capacity;
        a=new int[CAPACITY];
    }

    public int getParent(int i)
    {
        return (i-1)/2;
    }

    public int getLeft(int i)
    {
        return (2*i+1);
    }

    public int getRight(int i)
    {
        return (2*i+2);
    }

    public void swap(int[] a,int i,int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public int getMax()
    {
        if(heapSize==0) return Integer.MIN_VALUE;
        return a[0];
    }

    public void maxHeapify(int n,int i)
    {
        int largest= i;
        int left=getLeft(i);
        int right= getRight(i);

        if(left<n && a[left]>a[largest])
            largest=left;
        if(right<n && a[right]>a[largest])
            largest=right;

        if(largest!=i)
        {
            swap(a,largest,i);
            maxHeapify(n,largest);
        }
    }

    public int extractMax()
    {
        if(heapSize==0) return Integer.MIN_VALUE;
        if(heapSize==1)
        {
            heapSize--;
            return a[0];
        }
        int max=a[0];
        a[0]=a[heapSize-1];
        heapSize--;
        maxHeapify(heapSize,0);
        return max;
    }

    public void increaseKey(int i,int newVal)
    {
        a[i]= newVal;
        while (i!=0 && a[getParent(i)]<a[i])
        {
            swap(a,i,getParent(i));
            i=getParent(i);
        }
    }

    public void insertKey(int key)
    {
        if(heapSize==CAPACITY)
        {
            System.out.println("Overflow");
            return;
        }
        heapSize++;
        int i = heapSize-1;
        a[i]=key;
        while (i!=0 && a[getParent(i)]<a[i])
        {
            swap(a,i,getParent(i));
            i=getParent(i);
        }
    }

    public void buildMaxHeap(int a1[])
    {
        for (int i = 0; i < a1.length; i++) {
            insertKey(a1[i]);
        }
    }

    public int[] heapSort(int[] a1)
    {
        for (int i = 0; i < a1.length; i++) {
            insertKey(a1[i]);
        }
        for (int i = a1.length-1; i >=0 ; i--) {
            swap(a,i,0);
            maxHeapify(i,0);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] val={20,13,4,2,30,9,1};
        MaxHeap heap = new MaxHeap(val.length);
        val = heap.heapSort(val);
        System.out.println(Arrays.toString(val));
    }
}
