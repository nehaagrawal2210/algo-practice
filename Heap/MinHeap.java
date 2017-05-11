package Heap;

import java.util.Arrays;

/**
 * Created by neha on 2/26/2017.
 */
public class MinHeap {

    int CAPACITY;
    int[] a;
    int heapSize;

    public MinHeap(int capacity)
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

    public void minHeapify(int l, int i)
    {
        int smallest=i;
        int left=getLeft(i);
        int right=getRight(i);
        if(left<l && a[smallest]>a[left])
            smallest=left;
        if(right<l && a[smallest]>a[right])
            smallest=right;
        if(smallest!=i)
        {
            swap(a,smallest,i);
            minHeapify(l,smallest);
        }
    }

    public void insertKey(int val)
    {
        if(heapSize==CAPACITY)
        {
            System.out.println("Overflow!");
            return;
        }
        heapSize++;
        int i=heapSize-1;
        a[i]=val;

        while (i!=0 && a[getParent(i)]>a[i]){
            swap(a,getParent(i),i);
            i=getParent(i);
        }
    }

    public void replaceKey(int i, int newVal)
    {
        int temp=a[i];
        a[i]=newVal;
        if(newVal>temp)
        {
            //heapify children
            minHeapify(heapSize,i);
        }
        while (i!=0 && a[getParent(i)]>a[i])
        {
            swap(a,getParent(i),i);
            i=getParent(i);
        }
    }

    public int getMin(){
        if(heapSize==0) return Integer.MAX_VALUE;
        return a[0];
    }

    public int extractMin(){
        if(heapSize==0) return Integer.MAX_VALUE;
        if(heapSize==1) {
            heapSize--;
            return a[0];
        }
        int min = a[0];
        a[0]=a[heapSize-1];
        heapSize--;
        minHeapify(heapSize,0);
        return min;
    }

    public int[] heapSort(int[] a1)
    {
        for (int i = 0; i < a1.length; i++) {
            insertKey(a1[i]);
        }

        for (int i = a1.length-1; i >=0 ; i--) {
            swap(a,i,0);
            minHeapify(i,0);
        }
        return a;
    }


    public void deleteKey(int i)
    {
        replaceKey(i,Integer.MIN_VALUE);
        extractMin();
    }

    public static void main(String[] args) {
        int[] val={20,13,4,2,30,9,1};
        MinHeap heap = new MinHeap(val.length);
        val = heap.heapSort(val);
        System.out.println(Arrays.toString(val));
    }
}
