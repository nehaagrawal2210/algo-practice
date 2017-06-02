package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 5/27/17.
 */
public class SearchRotatedPivotedArray extends TestCase {
    public int searchArray(int[] a, int key)
    {
        int pivot = findPivot(a,0,a.length-1);
        if(pivot == -1) return binarySearch(a,0,a.length-1,key);
        int index = binarySearch(a,0,pivot,key);
        if(index==-1) index = binarySearch(a,pivot+1,a.length-1,key);
        return index;
    }

    public int binarySearch(int[] a,int low,int high,int key)
    {
        if(low>high) return -1;
        int mid = low + (high-low)/2;
        if(a[mid]==key) return mid;
        if(a[mid]>key) return binarySearch(a,low,mid-1,key);
        else return binarySearch(a,mid+1,high,key);
    }

    public int findPivot(int[] arr, int low, int high)
    {
        if(high<low) return -1;
        int mid = (low + high)/2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid-1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid-1);
        return findPivot(arr, mid + 1, high);
    }

    public void testGetPivot()
    {
        int[] a = new int[]{7,8,1,2,3,4,5,6};
        int[] a1 = new int[]{1,2,3,4,5,6};
        System.out.println(findPivot(a,0,a.length-1));
        System.out.println(findPivot(a1,0,a1.length-1));
        System.out.println(searchArray(a,6));
    }
}
