package array;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.LinkedList;

/**
 * Created by neha on 12/29/2016.
 */
public class MaxSubarray extends TestCase{

//    http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/

    public void getMaxElementSubarray(int[] a,int k)
    {
        Deque<Integer> queue= new LinkedList<>();
        int i;
        //preprocess first window
        for (i = 0; i < k; i++) {
            while (!queue.isEmpty() && a[i]>=a[queue.peekLast()])
                queue.removeLast();
            queue.addLast(i);
        }

        for (; i < a.length; i++) {
            System.out.print(a[queue.peekFirst()]+" ");

            while (!queue.isEmpty() && queue.peekFirst()<=(i-k))
                queue.removeFirst();
            while (!queue.isEmpty() && a[i]>=a[queue.peekLast()])
                queue.removeLast();
            queue.addLast(i);
        }
        System.out.print(a[queue.peekFirst()]);
        System.out.println();
    }

    @Test
    public void testGetMaxElementSubarray()
    {
        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int k=3;
        int arr1[]= {8,5,10,7,9,4,15,12,90,13};
        int win=4;
        getMaxElementSubarray(arr,k);
        getMaxElementSubarray(arr1,win);
    }
}
