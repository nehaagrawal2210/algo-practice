package array;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/20/2017.
 */
public class MajorityElement extends TestCase {
//    http://www.geeksforgeeks.org/majority-element/
    /*
    Moore's Voting algorithm
     */
    public int getCandidate(int a[])
    {
        int majIndex=0,count=1;
        for (int i = 1; i < a.length; i++) {
            if(a[majIndex]==a[i])
                count++;
            else
                count--;
            if(count==0)
            {
                majIndex=i;
                count=1;
            }
        }
        return a[majIndex];
    }

    public int getMajorityElement(int a[])
    {
        int majElemCandidate=getCandidate(a);
        int count=0;
        for (int i = 0; i < a.length; i++) {
            if(a[i]==majElemCandidate)
                count++;
        }
        if(count>a.length/2)
            return majElemCandidate;
        else return Integer.MIN_VALUE;
    }

    @Test
    public void testGetMajorityElement()
    {
        int a[] = new int[]{1, 3, 3, 1, 2};
        int k[] = new int[]{1, 1, 3, 1, 2};
        int k1[] = new int[]{1, 1, 3, 3, 2,1,4};
        assertEquals(Integer.MIN_VALUE,getMajorityElement(a));
        assertEquals(1,getMajorityElement(k));
        assertEquals(Integer.MIN_VALUE,getMajorityElement(k1));
    }

}
