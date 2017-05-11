package misc;

import java.util.Random;

/**
 * Created by neha on 1/18/2017.
 */
public class KSmallestElement {

    public static void main(String[] args) {

        int a[]={23,12,11,4,52,44};
        int z[]={23,12,11,4,52,44};
        int h[]={23,12,11,4,52,44};
        KSmallestElement smallestElems=new KSmallestElement();
        System.out.println(smallestElems.minHeapMethod(a,4));
        System.out.println(smallestElems.maxHeapMethod(z,7));
        System.out.println(smallestElems.partitionMethod(h,0,h.length-1,2));
    }

    public int minHeapMethod(int a[],int rank)
    {
        int kSmallest=Integer.MIN_VALUE;
        if(rank>a.length)
            return kSmallest;
        Heap heap=new Heap();
        //heap built here
        heap.buildMinHeap(a,a.length);
        int heapSize=a.length;

        //extract min rank times
        for (int i=0;i<rank;i++)
        {
            kSmallest=a[0];
            a[0]=a[heapSize-1];
            a[heapSize-1]=kSmallest;
            heapSize--;
            heap.minHeapify(a,heapSize,0);
        }
        return kSmallest;
    }

    public int maxHeapMethod(int a[],int rank)
    {
        int kSmallest=Integer.MIN_VALUE;
        if(rank>a.length)
            return kSmallest;
        //build max heap from first k elems
        Heap heap=new Heap();
        heap.buildMaxHeap(a,rank);

        //process remaining elems
        for(int i=rank;i<a.length;i++)
        {
            if(a[i]<a[0])
            {
                a[0]=a[i];
                heap.maxHeapify(a,rank,0);
            }
        }
        kSmallest=a[0];
        return kSmallest;
    }

    public int partitionMethod(int a[],int low,int high,int rank)
    {
        if(rank>0 && rank<=high-low+1) {
            int pivot = partition(a, low, high);
            if ((rank - 1) == (pivot - low))
                return a[pivot];
            else if ((rank - 1) < (pivot-low))
                return partitionMethod(a, low, pivot - 1, rank);
            else
                return partitionMethod(a, pivot + 1, high, rank - pivot + low - 1);
        }
        return Integer.MIN_VALUE;
    }

    public int partition(int a[],int low,int high)
    {
        Random random=new Random();
        int randomIndex=random.nextInt(high+1-low)+low;

        //randomize the pivot
        Util.swap(a,low,randomIndex);
        //get the pivot
        int pivot=a[low];

        int i=low;
        for (int j = low+1; j <= high; j++) {
            if(a[j]<=pivot)
            {
                i++;
                Util.swap(a,j,i);
            }
        }
        //move the pivot in between
        Util.swap(a,low,i);
        return i;
    }
}
