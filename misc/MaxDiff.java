package misc;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/14/2017.
 */
public class MaxDiff extends TestCase{

//    http://www.geeksforgeeks.org/maximum-difference-between-two-elements/
    public int getMaxDiff(int[]a)
    {
        int maxDiff=Integer.MIN_VALUE,minSoFar=a[0],diff;
        for (int i = 1; i < a.length; i++) {
            if(a[i]>minSoFar)
            {
                diff=a[i]-minSoFar;
                if(diff>maxDiff)
                    maxDiff=diff;
            }
            else {
                minSoFar=a[i];
            }
        }
        return maxDiff;
    }

    @Test
    public void testGetMaxDiff()
    {
        int arr[] = {1, 2, 90, 10, 110};
        int arr1[] = {80, 2, 6, 3, 100};
        assertEquals(109,getMaxDiff(arr));
        assertEquals(98,getMaxDiff(arr1));
    }

}
