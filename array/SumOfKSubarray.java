package array;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by neha on 2/16/2017.
 */
public class SumOfKSubarray extends TestCase{
//    http://www.geeksforgeeks.org/sum-minimum-maximum-elements-subarrays-size-k/
    public int getSum(int[] a,int k)
    {
        Deque<Integer> max=new LinkedList<>();
        Deque<Integer> min=new LinkedList<>();
        int i,sum=0;
        //first k elems
        for (i = 0; i < k; i++) {
            while (!max.isEmpty() && a[i]>=a[max.peekLast()])
                max.removeLast();
            while (!min.isEmpty() && a[i]<=a[min.peekLast()])
                min.removeLast();
            max.addLast(i);
            min.addLast(i);
        }

        for (;i < a.length; i++) {
            sum+=(a[max.peekFirst()]+a[min.peekFirst()]);
            while (!max.isEmpty() && max.peekFirst()<=(i-k))
                max.removeFirst();
            while (!min.isEmpty() && min.peekFirst()<=(i-k))
                min.removeFirst();
            while (!max.isEmpty() && a[i]>=a[max.peekLast()])
                max.removeLast();
            while (!min.isEmpty() && a[i]<=a[min.peekLast()])
                min.removeLast();
            max.addLast(i);
            min.addLast(i);
        }
        sum+=(a[max.peekFirst()]+a[min.peekFirst()]);
        return sum;
    }

    @Test
    public void testGetSum()
    {
        int arr[] = {2, 5, -1, 7, -3, -1, -2} ;
        int k = 3;
        int k1= 4;
        assertEquals(14,getSum(arr,k));
        assertEquals(18,getSum(arr,k1));
    }
}
