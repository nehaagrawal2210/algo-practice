package practice;

import junit.framework.TestCase;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by neagrawa on 5/28/17.
 */
public class MaxSubarraySizeK extends TestCase {
    public void printMaxSubarray(int[] a, int k)
    {
        Deque<Integer> queue = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        //process first window, find maximum and put in queue
        int max = 0,i;
        for(i=1;i<k;i++) if(a[i]>=a[max]) max=i;
        queue.add(max);
        // here i==k
        for(;i<a.length;i++)
        {
            res.add(a[queue.peekFirst()]);
            while (!queue.isEmpty() && queue.peekFirst()<=(i-k))
                queue.removeFirst();
            while (!queue.isEmpty() && a[queue.peekLast()]<=a[i])
                queue.removeLast();
            queue.addLast(i);
        }
        res.add(a[queue.peekFirst()]);
        for(Integer num: res)
            System.out.print(num+", ");
        System.out.println();
    }

    public void testGetMax()
    {
        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int k=3;
        int arr1[]= {8,5,10,7,9,4,15,12,90,13};
        int win=4;
        printMaxSubarray(arr,k);
        printMaxSubarray(arr1,win);
    }
}
