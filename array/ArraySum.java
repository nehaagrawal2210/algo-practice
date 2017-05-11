package array;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/20/2017.
 */
public class ArraySum extends TestCase{
    public int getMaxContiguousSum(int a[])
    {
        int maxSoFar=Integer.MIN_VALUE,maxEndingHere=0,start=0,s=0,end=0;
        for (int i = 0; i < a.length; i++) {
            maxEndingHere+=a[i];
            if(maxEndingHere>maxSoFar)
            {
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            }
            if(maxEndingHere<0)
            {
                maxEndingHere=0;
                s = i+1;
            }
        }
        System.out.println("Start = "+start+" End= "+end);
        return maxSoFar;
    }

    @Test
    public void testGetMaxContiguousSum()
    {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] a1 = {-2, -3, -4, -1, -2, -1, -5, -3};
        assertEquals(7,getMaxContiguousSum(a));
        assertEquals(-1,getMaxContiguousSum(a1));
    }
}
