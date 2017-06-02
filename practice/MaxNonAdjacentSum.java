package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 5/27/17.
 */
public class MaxNonAdjacentSum extends TestCase {
    public int getMaxAdjacentSum(int[] a)
    {
        int exSum=0,incSum=a[0],maxSum=Integer.MIN_VALUE;
        int exNew;
        for (int i = 1; i < a.length; i++) {
            exNew = Math.max(incSum,exSum);
            incSum = exSum+a[i];
            exSum = exNew;
        }
        return Math.max(exSum,incSum);
    }

    public void testG()
    {
        assertEquals(110,getMaxAdjacentSum(new int[]{5, 5, 10, 100, 10, 5}));
        assertEquals(4,getMaxAdjacentSum(new int[]{1, 2, 3}));
        assertEquals(20,getMaxAdjacentSum(new int[]{1, 20, 3}));
    }
}
