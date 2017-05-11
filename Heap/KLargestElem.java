package Heap;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Random;

/**
 * Created by neha on 2/26/2017.
 */
public class KLargestElem extends TestCase{
    public int partition(int a[],int low,int high)
    {
        Random random=new Random();
        int randomIndex = random.nextInt(high-low+1)+low;
        swap(a,low,randomIndex);

        int pivot=a[low],i=low;
        for (int j = low+1; j <= high; j++) {
            if(a[j]>=pivot)
            {
                i++;
                swap(a,i,j);
            }
        }
        swap(a,low,i);
        return i;
    }

    //find kth largest number
    public int partitionMethod(int a[],int low,int high,int rank)
    {
        if(rank>0 && rank<=high-low+1)
        {
            int pivot= partition(a,low,high);
            if((rank-1)==(pivot-low)) return a[pivot];
            else if((rank-1)<(pivot-low)) return partitionMethod(a,low,pivot-1,rank);
            else{
                return partitionMethod(a,pivot+1,high,rank-pivot+low-1);
            }
        }
        return Integer.MIN_VALUE;
    }

    public int maxHeapMethod(int[] a,int k)
    {
        MaxHeap heap= new MaxHeap(a.length);
        heap.buildMaxHeap(a);
        int kthLargest=Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            kthLargest= heap.extractMax();
        }
        return kthLargest;
    }

    public int minHeapMethod(int[] a,int k)
    {
        MinHeap heap = new MinHeap(k);
        int i,min;
        //insert first k elems in min heap
        for (i = 0; i < k; i++) {
            heap.insertKey(a[i]);
        }
        for (; i < a.length; i++) {
            min=heap.getMin();
            if(a[i]>min){
                heap.replaceKey(0,a[i]);
            }
        }
        return heap.getMin();
    }

    public void swap(int[] a,int i,int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    @Test
    public void testGetKLargest()
    {
        int[] a ={8,10,11,6,5,22,3,1};
        int[] a1 ={8,10,11,6,5,22,3,1};
        assertEquals(8,partitionMethod(a,0,a.length-1,4));
        assertEquals(1,partitionMethod(a,0,a.length-1,8));
        assertEquals(22,partitionMethod(a,0,a.length-1,1));
        assertEquals(22,maxHeapMethod(a1,1));
        assertEquals(1,maxHeapMethod(a1,8));
        assertEquals(8,maxHeapMethod(a1,4));
        int[] z ={8,10,11,6,5,22,3,1};
        assertEquals(22,minHeapMethod(z,1));
        assertEquals(1,minHeapMethod(z,8));
        assertEquals(8,minHeapMethod(z,4));

    }
}
