package practice;

import junit.framework.TestCase;
import misc.Util;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by neagrawa on 5/28/17.
 */
public class Sorting extends TestCase {
    public void quickSort(int a[])
    {
        int[] b = Arrays.copyOf(a,a.length);
        quickSort(b,0,a.length-1);
        System.out.println(Arrays.toString(b));
    }

    public void quickSort(int[] a,int p,int q)
    {
        if(p<q)
        {
            int pivot = partition(a,p,q);
            quickSort(a,p,pivot-1);
            quickSort(a,pivot+1,q);
        }
    }

    public int partition(int[] a,int p,int q)
    {
        Random r = new Random();
        int randIndex = r.nextInt(q-p+1)+p;

        //bring the random number to first position
        Util.swap(a,p,randIndex);

        int i=p;
        int pivot = a[p];
        for (int j = p+1; j <=q ; j++) {
            if(a[j]<pivot) {
                i++;
                Util.swap(a,i,j);
            }
        }
        Util.swap(a,p,i);
        return i;
    }

    public void mergeSort(int[] a)
    {
        int[] b = Arrays.copyOf(a,a.length);
        mergeSort(b,0,a.length-1);
        System.out.println(Arrays.toString(b));
    }

    public void mergeSort(int a[],int p,int r)
    {
        if(p<r)
        {
            int q= p+ (r-p)/2;
            mergeSort(a,p,q);
            mergeSort(a,q+1,r);
            merge(a,p,q,r);
        }
    }

    public void merge(int[] a,int low,int mid,int high)
    {
        int i=low,j=mid+1;
        int len = high-low+1;
        int[] b = new int[len];
        for (int k = 0; k <len ; k++) {
            if(i<=mid && (j>high || a[i]<=a[j])){
                b[k] = a[i++];
            }
            else{
                b[k] = a[j++];
            }
        }
        for (int k = 0; k <len; k++) {
            a[low+k] = b[k];
        }
    }

    public void heapSort(int[] a)
    {
        int[] b = Arrays.copyOf(a,a.length);
        int heapSize= b.length;

        for (int i = heapSize/2; i >= 0 ; i--) {
            heapify(b,heapSize,i);
        }
        for (int i = heapSize-1; i >= 0 ; i--) {
            Util.swap(b,0,i);
            heapify(b,i,0);
        }
        System.out.println(Arrays.toString(b));
    }

    public void heapify(int a[],int n,int i)
    {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left<n && a[left]>a[largest])
            largest=left;
        if(right<n && a[right]>a[largest])
            largest=right;

        if(largest!=i)
        {
            Util.swap(a,i,largest);
            heapify(a,n,largest);
        }
    }

    public void testPartition()
    {
        int[] a = {5,3,1,6,9,12,0};
        int[] b = {5,6,9,3,1,2,0};
        quickSort(a);
        quickSort(b);
        mergeSort(a);
        mergeSort(b);
        heapSort(a);
        heapSort(b);
    }

}
