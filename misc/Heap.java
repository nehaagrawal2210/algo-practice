package misc;

/**
 * Created by neha on 1/18/2017.
 */
public class Heap {

    public void maxHeapify(int a[],int heapSize, int i)
    {
        int left=2*i+1;
        int right=2*i+2;
        int largest=i;

        if(left<heapSize && a[left]>a[largest])
        {
            largest=left;
        }
        if(right<heapSize && a[right]>a[largest])
        {
            largest=right;
        }
        //swap largest with root
        if(largest!=i)
        {
            swap(a,largest,i);
            maxHeapify(a,heapSize,largest);
        }
    }

    public void minHeapify(int a[],int heapSize,int i)
    {
        int left=2*i+1;
        int right=2*i+2;
        int lowest=i;

        if(left<heapSize && a[left]<a[lowest])
        {
            lowest=left;
        }
        if(right<heapSize && a[right]<a[lowest])
        {
            lowest=right;
        }
        if(lowest!=i)
        {
            swap(a,lowest,i);
            minHeapify(a,heapSize,lowest);
        }
    }

    public void buildMaxHeap(int a[],int heapSize)
    {
        for (int i=heapSize/2;i>=0;i--)
        {
            maxHeapify(a,heapSize,i);
        }
    }

    public void buildMinHeap(int a[],int heapSize)
    {
        for (int i=heapSize/2;i>=0;i--)
        {
            minHeapify(a,heapSize,i);
        }
    }

    public void maxSort(int a[])
    {
        buildMaxHeap(a,a.length);
        //perform heap sort, max elem is at the root
        for (int i=a.length-1;i>0;i--)
        {
            swap(a,0,i);
            maxHeapify(a,i,0);
        }
    }

    public void minSort(int a[])
    {
        buildMinHeap(a,a.length);
        //perform heap sort, min elem is at root
        for (int i=a.length-1;i>0;i--)
        {
            swap(a,i,0);
            minHeapify(a,i,0);
        }
    }

    //helper function for swap
    public void swap(int a[],int i,int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public void printArray(int a[])
    {
        for (int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int a[]={20,13,4,2,30,9,1};
        int z[]={20,13,4,2,30,9,1};
        Heap sort=new Heap();
        sort.maxSort(a);
        sort.minSort(z);
        sort.printArray(a);
        sort.printArray(z);
    }
}
