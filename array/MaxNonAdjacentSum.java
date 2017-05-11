package array;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/21/2017.
 */
public class MaxNonAdjacentSum extends TestCase {
//    http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/

    public int getSum(int[] a)
    {
        int including= a[0], excluding= 0,tempExcluding=0;
        for (int i = 1; i < a.length; i++) {
            excluding=Math.max(excluding,including);
            including=tempExcluding+a[i];
            tempExcluding = excluding;
        }
        return Math.max(including,excluding);
    }


    @Test
    public void testSum()
    {
        int arr[] = {5, 5, 10, 100, 10, 5};
        int arr1[] = {5,1,2,100};
        assertEquals(110,getSum(arr));
        assertEquals(105,getSum(arr1));
    }
}
